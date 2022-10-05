public class MainApp {
    public static void main(String[] args)
    {
         AppleBox AppleBoxy = new AppleBox(new Apple(),new Orange(),new Banan());
         AppleBoxy.BoxName = "Яблок";

         BananaBox BananaBoxy = new BananaBox(new Apple(),new Orange(),new Banan());
         BananaBoxy.BoxName = "Бананов";

         OrangeBox OrangeBoxy = new OrangeBox(new Apple(),new Orange(),new Banan());
         OrangeBoxy.BoxName = "Апельсинов";

         AppleBox AppleBoxy2 = new AppleBox(new Apple(),new Orange(),new Banan());
         AppleBoxy2.BoxName = "Яблок 2";

         BananaBox BananaBoxy2 = new BananaBox(new Apple(),new Orange(),new Banan());
         BananaBoxy2.BoxName = "Бананов 2";

         OrangeBox OrangeBoxy2 = new OrangeBox(new Orange(), new Orange());
         OrangeBoxy2.BoxName= "Апельсинов 2";

//        AppleBoxy.add(new Apple());       //Добавим в яблочную коробку яблоки
//        AppleBoxy.add(new Banan());       //Добавим в яблочную коробку бананы
//        AppleBoxy.add(new Orange());      //Добавим в яблочную коробку апельсины
//        AppleBoxy.MoveFrom(AppleBoxy2);   //Переместить в яблочную коробку яблочную коробку
//        AppleBoxy.MoveFrom(BananaBoxy);   //Переместить в яблочную коробку банановую коробку
//        AppleBoxy.MoveFrom(OrangeBoxy);   //Переместить в яблочную коробку апельсиновую коробку

//        BananaBoxy.add(new Apple());      //Добавим в банановую коробку яблоки
//        BananaBoxy.add(new Banan());      //Добавим в банановую коробку бананы
        BananaBoxy.add(new Orange());     //Добавим в банановую коробку апельсины
        BananaBoxy.MoveFrom(AppleBoxy);   //Переместить в банановую коробку яблочную коробку
//        BananaBoxy.MoveFrom(BananaBoxy2); //Переместить в банановую коробку банановую коробку
//        BananaBoxy.MoveFrom(OrangeBoxy);  //Переместить в банановую коробку апельсиновую коробку
//
//        OrangeBoxy2.add(new Apple());      //Добавим в банановую коробку яблоки
//        OrangeBoxy2.add(new Banan());      //Добавим в банановую коробку яблоки
//        OrangeBoxy2.add(new Orange());     //Добавим в банановую коробку яблоки
//        OrangeBoxy2.MoveFrom(AppleBoxy);   //Переместить в апельсиновую коробку яблочную коробку
//        OrangeBoxy2.MoveFrom(BananaBoxy);  //Переместить в апельсиновую коробку банановую коробку
       // OrangeBoxy2.MoveFrom(OrangeBoxy);  //Переместить в апельсиновую коробку апельсиновую коробку
        //OrangeBoxy2.compare(AppleBoxy2);
        //OrangeBoxy2.info();
        //AppleBoxy.info();
        BananaBoxy.info();
    }
}