import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;
        String sql = "";

        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "furik99");
            System.out.println("База данных успешно создана");

            Cat cat = new Cat("хуй", 51422350, Color.Black.toString(),Parent.Vazya.toString());

            Method m = cat.getClass().getMethod("SomeMethod");
            Table table = m.getAnnotation(Table.class);
            String tableName = table.title();

            Field[] classFields = Cat.class.getFields();
            List<Field> list = new ArrayList<>();

            for(Field e : classFields){
                if (e.isAnnotationPresent(Column.class)){
                    list.add(e);
                }
            }

            Field[] jo = new Field[list.size()];
            list.toArray(jo);

            stmt = c.createStatement();
            String create = "CREATE TABLE IF NOT EXISTS ";
            create += tableCreate(tableName, jo);
            stmt.executeUpdate(create);
            stmt.close();

            PreparedStatement ps = c.prepareStatement("INSERT INTO " + tableName + " VALUES (?, ?, ?)");
            ps.setString(1, cat.name);
            ps.setInt(2, cat.age);
            ps.setString(3, cat.color);
//            ps.setString(4, cat.parent);
            ps.addBatch();
            ps.executeBatch();
            c.close();
        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    public static String tableCreate(String tableName, Field[] classFields){
        String result = "";
        result += tableName + " (";
        for (int i = 0; i < classFields.length; i++){
            Field f = classFields[i];
            if(f.getType().getName() == "java.lang.String"){
                result += f.getName() + " text NOT NULL";
            } else {
                result += f.getName() + " " + f.getType().getName() + " NOT NULL";
            }
            if(i+1 != classFields.length){
                result += ", ";
            } else{
                result += ");";
            }
        }
        return  result;
    }
}