package myOwnPackage;
public class Oops_31{
    public static void main(){
        //Oops questions are asked in interviews 
        //object : entity in the real world ->pen, animal, watch etc..
        //class: group of these entities -> ek original class ki terha smjho jiske ander similar age k students 
        // ho,same books padhe sub,subka grade jaise 10th ho (class mtlab 10th class k students h sub ek class k ander),
        //subke same uniform ho and etc.. -> toh ek class k ander coding m bhi aese he wo functions aur wo properties 
        // hoti h jo uske ander k subke liye similar ho same ho kuch related si ho ki ek he kisam k logo se related 
        // cheeze ek class ke ander likhi jaati h


        /*
        example k liye:
        ager ab koe maruti ki car bnani h code k through bnwani h 
        toh hum ek blueprint likhke rakh denge like color kya hoga uska ,body kaisi hogi, logo kaisa ,design kaisa ,horn 
        kaise work krega,break kaise lagenge etc,, hum yeh sub functions n properties ki through bs ek blueprint bnake rakhenge
        fir isska jub real mai use hoga real world mai objects bna bnake mtlab kahi saari maruti bnn jayengi
        toh uss real world maruti k cheez ko hum object kahenge aur objects kahi saare bnn skte h ek he class k liye
        "class is the blueprint of an object." -> asa kaha bhi jaata h! 
         */ 


        /*
        class k ander :
        1)attributes or properties.
        2)methods (or functions).

        example: pen class has:
        1)color as a attribute
        2)change color() as a method to change that color
        */

        //ab lets go to pen class and student class->remember public class k alawa koe bhi class ho wo main class wale method 
        //wali class k neechey se he likhne h uper likhoge toh error ayega->now go down to pen class check the code:
        // Pen p1=new Pen(); //->ab yaha new likhne se class k attributes(properties) memory m store hongi 
        //p1->object h
        //Pen()->yeh ek constructor(a special type of a function) h yaha-> discussed later 
        /*
        computer k ander 2 types ki memory hoti h:
        1)stack 
        2)heap -> objects is created inside this -> ab yaha pr humara color aur tip variable create hue h and "new" keyword
        //se string size jitni color k liye and int size jitni tip k liye reserve ho gyi h jagha
        
        //ab access krna sikhte h .(dot operator) ki help se hoga sub      

        */
    //    System.out.println(p1.color); 
    //    p1.changeColor("green");
    //    System.out.println(p1.color);

    //    System.out.println(p1.tip);
    //    p1.setTip(10);
    //    System.out.println(p1.tip);

       //change krne ka dusra tarika
    //    p1.color="yellow";
    //    System.out.println(p1.color);
       //Note: change kitni bhi baar aram se kr skte h koe problem ni hogi 


       //access modifiers in one note smjhati hu
       //BankAccount class se smjhate h ab use case
    //    BankAccount myAcc=new BankAccount();
    //    System.out.println(myAcc.userName);
    //    myAcc.userName="Iesha negi";
    //    System.out.println(myAcc.userName);
       //myAcc.password="iesha18"; //hover kro password pr and see it is not accessible
    //    myAcc.setPassword("iesha5");
    //    System.out.println(myAcc.password); //yeh aese bhi accessible nahi hoga


    //by default hum 2 tarike k functions bnate h kisi bhi object k sath:
    //1)getters -> it returns the asked attribute's value
    //2)setters -> it sets that value
    //lets see this in class BankAcc
        // System.out.println(myAcc.getUserName());
        // myAcc.setUserName("tanu");

    
    //Oops k ander 4 major pillars hote h:
    //1)encaptulation
    //2)inheritance
    //3)polymorphism
    //4)abstraction
    //koe sequence ni hota koe bhi pehele padh skte ho


    //1)Encaptulation-it is defined as wrapping up of data(property) and method(functions) in a single unit(class).
    //                It can also implement data hiding(using access specifiers-private,default,protected and public).


    //constructor-> it is a function that is called automatically when an object is created.
                  //so jaise he object create hota h waise he constructor call hoga and object ko memory di jayegi 
                  //waha pt  fir color,tip jaise properties(data) store honge.
                  //.> constructors have the same name as the class
                  //.>constructors don't have any return type (not even void).
                  //.> objects are only called once, during object creation. baki kabhi possible nahi h like
                  //   pen class k liye ager hum Pen p1=new Pen(); asa likhke ab already constructor call kr chuke h
                  //   toh ab yeh possible nahi h ki hum p1.Pen() likhke firse call kr paye.
                  //.>memory allocation happens when a constructor is called.
    //Note: ager kisi class mai jaise Pen wali mai BankAccount wali m ager constructor ni bnaya tha humne toh java 
    //ek default constructor create krta h and usse call krta h but wo constructor khaali hota h 
    //like usme kuch bhi initialize nahi hora hota kuch ni hora hota.
    
    // Student s1=new Student();
    //with parameter wala consructor k liye aese likhte h:
    // Student s1=new Student("Iesha negi");
    // System.out.println(s1.name);

    //without constructor bna hua class jo hota h usme java default constructor kuch aese wala hota h jisse call krta h
    // Student s1=new Student();


    //different typed of constructor called according to requirement:
    // Student s1=new Student();
    // Student s2=new Student("iesha");
    // Student s3=new Student(9);
    // Student s4=new Student("iesha",9); //yeh error dega kyuki aesa koe constructor ni h jisme dono values k liyr parameter ho.
    

    //copy constructor:
    // Student s1=new Student("tanu",23,"abc9");
    // Student s2=new Student(s1);
    // System.out.println(s2.name);
    // System.out.println(s2.rollNo);
    // s2.password="xyz";
    // System.out.println(s2.password); //yeh alag hoga bs

    //copy constructor ka disadvantage:->shallow copy
    // Student s1=new Student("tanu",23,"abc9");
    // s1.marks[0]=90;
    // s1.marks[1]=80;
    // s1.marks[2]=95;
    // Student s2=new Student(s1);
    // System.out.println(s2.name);
    // System.out.println(s2.rollNo);
    // s2.password="xyz";
    // System.out.println(s2.password); //yeh alag hoga bs
    // for(int i=0;i<3;i++){
    //     System.out.print(s2.marks[i]+" ");
    // }
    // System.out.println();
    // s1.marks[0]=100;
    // for(int i=0;i<3;i++){
    //     System.out.print(s2.marks[i]+" ");
    // }
    //yaha actually wo aagaya s2 mai s1 ka change marks[0] pr 100 show ho gaya 
    //kyuki neechey jaha humne likha h:
    /*
    Student(String name,int rollNo,String password){
        this.name=name;
        this.rollNo=rollNo;
        this.password=password;
        this.marks=new int[3]; 
    }
    Student(Student s1){
        this.name=s1.name;
        this.rollNo=s1.rollNo;
        this.marks=s1.marks; --> yaha humara s2 bhi bs point krna start kr diya marks wale array ka reference h s2 k pass bs
                                 yeh koe copy ni ho gaya tha direct isliye jo changes s1 mai honge wo s2 m bhi dikhenge
                                 chahe object create pehele he ho gaya ho yaha :
                                 Student s2=new Student(s1); 
                                 isko kehete h shallow copy yaha bs marks array ka reference copy hua pura ka
                                 pura array nahi copy hua
    }
    
    */ 

    /*
    shallow copy-> references are copied of a array or a class and changes reflect.
    deep copy-> new marks array is created and changes don't reflect
    
    */
   //deep copy:
//    Student s1=new Student("tanu",23,"abc9");
//     s1.marks[0]=90;
//     s1.marks[1]=80;
//     s1.marks[2]=95;
//     Student s2=new Student(s1);
//     System.out.println(s2.name);
//     System.out.println(s2.rollNo);
//     s2.password="xyz";
//     System.out.println(s2.password); //yeh alag hoga bs
//     for(int i=0;i<3;i++){
//         System.out.print(s2.marks[i]+" ");
//     }
//     System.out.println();
//     s1.marks[0]=100; //ab koe change nahi ayega
//     for(int i=0;i<3;i++){
//         System.out.print(s2.marks[i]+" ");
//     }

        /*
        Destructors: yeh java mai nahi bnate java mai garbage collector hota h jo ki dekhta h ki memory mai ager koe 
        unused object ya variable ya kuch bhi padha h toh usse remove krdeta h memory se
         */

        //2.Inheritance
        // it is when properties and methods of a base(parent) class are passed on to a derived(child) class.
        //like: genes are paseed from dada dadi to ur parents and from them to you.
        // Fish shark=new Fish();
        // shark.eats();
        // shark.swims();
        /*
        Types of inheritance:
        1)single level inheritance-> jo humne abhi dekha single base class se single derived class ne inherit kiya
        2)Multi level inheritance -> (Base class ->derived class ->derived class) like (Animal->Mammal->dog)
        3)hierarchichal inheritance -> 1 base class aur usse se bhut saari classes inherit kr ri h like (Animal) <-base class
                                                                                                       /   |   \
                                                                                Derived classes->   fish  bird  mammal
        4)Hybrid inheritance-> kuch bhi hora hota h yaha (hierarchichal + single level) or 
        (multi level + hierarchichal + single level) or (single level + multi level) etc-> one note pr google ki
         image se smjhati hu -> baki ap try krna isko implement krke khud aur m bhi live krti hu yaha pr isse

         5) Multiple inheritance -> yeh java m ni hota directly c++ m hota h pr ..isko yaha implement krne k liye hume 
         interfaces naam ka concept sikhna hoga aage waha dekhenge kaise implement krte h iss inheritance ko interfaces 
         ki help se
        */

        // 2)Multi level inheritance -> (Base class ->derived class ->derived class) like (Animal->Mammal->dog)
        // Dog d1=new Dog();
        // d1.legs=4;
        // System.out.println(d1.legs);
        // d1.eats();
        // d1.breed="golden retriever";
        // System.out.println(d1.breed);

        // 3)hierarchichal inheritance -> 1 base class aur usse se bhut saari classes inherit kr ri h like (Animal) <-base class
        //                                                                                                /   |   \
        //                                                                         Derived classes->   fish  bird  mammal
        // Fish f1=new Fish();
        // Bird b1=new Bird();
        // Mammal m1=new Mammal();
        // f1.eats();
        // f1.swims();
        // b1.eats();
        // b1.flies();
        // m1.eats();
        // m1.walks();

        //3) polymorphism: when we do same things in multiple forms poly:many and morph: forms
            // Types:
            //1) compile time (static)-> jo compiler ko compile krte time various forms dikhe wo h compile time polymorphism
            //                           iska method h Method Overloading
            //2) run time (dynamic polymorphism)->jo compiler ko na pata chale but run time pr pata chale wo run time poly. hota h
            //                           iska method h Method Overriding

        
        //Method overloading: same name functions but differnt data types or numbers of parameters
        //bata rakha h maine waise ab inshort batari hu:
        //sum(int a,int b)
        //sum(int a,float b)
        //sum(double a,int b, int c,float d)
        //sum(doble a,double b)
        //inn subme parameters ko dekho alag h bs yehi hota h isme aur haa yaad rakhna ki return type of function void ho subka
        //ya int ho ya double ya kuch ka same kuch ka alg jo bhi ho uss return type se koe frk ni padhta 
        //method overloading ka kaam bs parameters k type aur number of paramters pr he depend krta h alag honge toh he method 
        //overloading hogi wrna nahi
        // Calculator cal=new Calculator();
        // System.out.println(cal.sum(2,2)); //int int wala he call hoga 
        // System.out.println(cal.sum(4.3,5));//double int wala he call hoga 
        // System.out.println(cal.sum(3.2f,7.4f));//float float wala he call hoga 
        // System.out.println(cal.sum(3,3.2f,2.4f)); //int float float wala he call hoga 
        
        //Method overriding: different class having same function name and return type but different defination like:
        // Animal a1=new Animal();
        // Deer d1=new Deer();
        // a1.eats(); //yeh anumal wala eats function chalayega 
        // d1.eats(); //yeh deer wala eat function chalayega

        //packages: in java similar type of classes,interfaces and subpackages are grouped together like 
        // in a shopping app rating dene wali jagha pr giveRating naam ka class hoga, delete rating k liye alag class,
        // rating number between 1-5 ka bhi hoga aur yeh sub cheeze rating related h isliye ek package k ander ayengi
        //aese he search krne ka app mai koe product alag package hoga,
        //Like: google k Maps ka alag package hoga,pay ka alag aur, docs ka alag hoga,slides ka alag hoga etc..
        //Types:
        //1)in-built packages-> example: Scanner class wala 
        //2)user defined packages-> subse uper dekho package mypackage;
        /*
        Alternative Ways to Access a PackageIf you do not want to import just one class, you have two other options: 
        Import the entire package: Use a wildcard * to pull in everything from that package.
        import mypackage.*; 
        Like:
        import java.util.*; -> for Scanner class use

        package myOwnPackage;-> yeh krne mai dekhna thodi problem ayegi toh isse khud soilve krna ap bhi hint de deti hu
        yaad rakhna code ko run ap apki olacement_java wale foler m reheke kroge naki myOwnPackage wale folder k ander jaake
        
        
        */

        //4)Abstraction:-> hiding unnecessary details while showing important parts to the user.
        /*
        Abstarction        |       Encapsulation
        -------------------|----------------------
        1)isme at least    |  1)iske data hiding mai unnecessay 
          important info   |    cheezo ko sirf chupate h but 
          user ko dikhate h|    important cheezo ko  user ko  
          data hide krne k |    show krne ka koe concept nahi
          alawa            |    h isme.
        */
       //abstarction is done in 2 ways:
       //1)class
       //2)interfaces
       //Note: Abstarction m hum user ko ya subclasses ko idea dete h ki koe cheez kaise implement hongi but actually
       //koe implementation ni dete

       //Abstract class
       //.> we cannot create instance of a abstract class
       //.>we can have abstract and non-abstract methods inside abstract class
       //.>we can make constructors

    //   Horse h1=new Horse();
    //   Chicken c1=new Chicken();
    //   h1.eats();
    //   h1.walks();
    //   System.out.println(h1.color);
    //   h1.speed();
    //   c1.eats();
    //   c1.walks();
    //   c1.speed();
    //   System.out.println(c1.color);
    //   Animals a1=new Animals(); //Cannot instantiate the type Animals yeh error milega



    //hierarchy of constructor calling
    // Mustang m1=new Mustang(); //pehele animal ka -> fir horse ka-> fir mustang ka.



    //interfaces-> interfaces is a blue print of a class
    //ex: car(wheel,speed,engine)->interface(blueprint of class)
    //               |
    //               v
    //           maruti 800->class(blueprint of object)
    //         /  /  | \ \  \
    //        v  v   v  v v  v
    //      m1   m2  m3 m4 m5 m6 ->objects (instance of a class)
    

    //interfaces ki jarurat kya padhi thi? ->interview mai puch skte h
    //answer-> 1)multiple inheritance ko implement krne k liye aur (jaise mummy daddy k genes hum sub mai aate h eyes, nose,etc..)
     //        2)total abstraction ko implement krne k liye(yaha interfaces mai 100% abstraction ho jaati h)

     /*
                  class                   |              Interface
        1)uses extends keyword to inherit.| 1)uses implements keyword to inherit.
                                          | 2)All methods are public,abstract and 
                                             without implementation.
                                            3) used to achieve total abstraction.
                                            4) variables in interface are public,static(jo variable bs class k liye ek 
                                             he baar create hoga use static rakhenge) and final(varble ki value jaise h same rahegi)
                                          
        
     
     */
    // Queen q=new Queen();
    // q.moves();


    //multiple inheritance using interfaces->2 and class->1
    /*herbivorous    carnivorous
        \              /
            bear
    */

        // Bear b=new Bear();
        // b.eats();


    //Oops question 1
    //real+imaginary=4+3i
    // ComplexNo c1=new ComplexNo(2,3);
    // ComplexNo c2=new ComplexNo(4,5);
    // c1.add(c2);
    // c1.subtract(c2);
    // c1.multiply(c2);


    //https://www.w3schools.com/java/java_try_catch.asp ->ugo read this link content


    //static keyword-used to share same variable or method or block or nested classes in a class 
    // to all the objects getting created for that class 
    /*
    yeh hota h nested class yeh class b aur c dono ek he baar bnegi
    class A{
        class B{
            class c{
            
            }
        
        }
    
    }
    
    
    */
        // Employee e1=new Employee();
        // e1.company="Google";
        // Employee e2=new Employee();
        // System.out.println(e2.company);
        // Employee e3=new Employee();
        // System.out.println(e3.company);
        // e3.company="Microsoft"; //isne jo bhi bdla wo sub objects k liye badal gaya kyuki static ka yehi kaam hota h
        // System.out.println("e1 company:"+e1.company);
        // System.out.println("e2 company:"+e2.company);
        /*
        Note: yeh change isliye ho gaya kyuki sub objects k bnte he company naam ka static hua variable memory m same location pr 
        point kr ra h 
        //ab same aese he humara main function bhi static hota h-> aager hum Oops class ka object bnaye aur main() ko call kre
        toh bs ek he function call hona chahiye

        static keyword use krne se memory m bs ek baar he ek variable ya function ya class ya block bnta h aur changes 
        ussi m hongi and subko reflect honge

        like koe function bnaye average calculate krne ka 3 numbers ka toh uska logic same hoga but for each student 
        alag alg marks honge subke so yeh funcion har object k liye alg na bnta rahe memory m toh hum isko static bnate h
        */
    //    System.out.println(e1.salaryOfThreeMonths(4543544, 343545, 23451));
    //    System.out.println(e1.salaryOfThreeMonths(45434, 3445, 4451));


    //super keyword-> it is used to refer immediate parent class object.
    //it is used to access parent class: properties,functions and constructors
    //iska use waise java humare bina likhey bhi kr he deta h 
        Child c1=new Child();
        System.out.println("parents age: "+c1.age);




        /*
        Constructor Chaining kya hai?

        Jab ek constructor dusre constructor ko call karta hai, use constructor chaining kehte hain.
        constructor chaining k baare m batao asan aur kmm shabdo mai aur code se smjha do koe easy se iski implementation bhi

Bilkul 😊 Constructor Chaining ko bahut simple way mein samjho:

Constructor Chaining kya hai?

Jab ek constructor dusre constructor ko call karta hai, use constructor chaining kehte hain.

Java mein iske liye:

this() → same class ke doosre constructor ko call karta hai.
super() → parent class ke constructor ko call karta hai.
Easy example: this()
class Student {

    Student() {
        this(10);   // doosre constructor ko call
        System.out.println("Default constructor");
    }

    Student(int age) {
        System.out.println("Age = " + age);
    }

    public static void main(String[] args) {
        Student s = new Student();
    }
}
Output:
Age = 10
Default constructor
Dry run 👇

Humne likha:

Student s = new Student();

➡️ Student() constructor call hua.

Uske andar:

this(10);

➡️ Student(int age) call hua.

Wahan:

System.out.println("Age = " + age);

➡️ Age = 10

Phir control wapas Student() mein aaya:

System.out.println("Default constructor");

➡️ Default constructor

So:

Student()
   ↓
this(10)
   ↓
Student(int age)
   ↓
back to Student()
⭐ Ek line mein yaad rakho:

Constructor chaining = ek constructor se doosre constructor ko call karna.

Aur ek important rule:

this();

ya

this(10);

constructor ke andar sabse pehli statement honi chahiye.

Aur ek important rule:

this();

ya

this(10);

constructor ke andar sabse pehli statement honi chahiye.
ager yeh this default constructor wali statement k baad this(10) likha hota constructor k ander toh kya tb 
isse consructor chainig ni bol skte?

Haan, conceptually woh constructor chaining karne ki koshish hogi, lekin Java mein allowed nahi hai. 😄

Example:

class Student {

    Student() {
        System.out.println("Default constructor");

        this(10);   // ❌ ERROR
    }

    Student(int age) {
        System.out.println("Age = " + age);
    }
}

Yahan compiler error dega:

call to this must be first statement in constructor
Kyun?

Java ka rule hai:

this() ya super() constructor ki first statement hi honi chahiye.

Isliye:

Student() {
    this(10);                  // ✅ first statement
    System.out.println("Hi");
}

Ye valid hai aur constructor chaining hogi.

Lekin:

Student() {
    System.out.println("Hi");  // ❌ pehle kuch aur
    this(10);                  // ❌
}

Ye compile hi nahi hoga.

Simple yaad rakhna 🧠

this() = constructor ko call karna → hamesha FIRST.

Aur haan, agar this(10) ko baad mein likhoge, Java usse constructor chaining ke roop mein execute nahi karega, 
kyunki program compile hi nahi hoga.


*/

//ab yaad rakhna humne nichey koe bhi class k sath access mofifier n lagaya but wo by default default type ka h
//aur humari iss file ka naam aur public hue wi class Oops.java ka naam same hona hahiye aur main fucntion bhi ussi
//k ander hona chahiye
//remember: koe bhi class k aage private nahi likhna kyuki uska na koe object bnn payega fir kisi bhi dusri class m aur na 
// he koe use hoga so  and same protected type ki bhi ni h allowed in java
//one note pr batati hu image se classes k liye access modifers

//parent reference=child object -> is possible
// like vehicle parent class and car child class h so correct kon konse h object creation k tarike?
//Vehicle v=new Vehicle(); -> x cheeze thi isme 
//Car c=new Car(); -> x+y cheeze thi isme 
//Vehicle v=new Car(); --> isme vehicle v bs x cheeze janta h aur wo jub point kr ra h x+y cheezo wale class pr toh wo bs
//x he cheeze access and use kr skta h bs y ko nahi so hum bolte h ki Left side → reference type = Vehicle
// Right side → object type = Car
//aur ager Car c=new Vehicle(); likhenge toh compile time error ni ayega run time error ayega 
// jub c object khudke y wale cheezo ko access krne ki try krega usse milengi he ni kyuki memory m bs vehicle k karan
//x cheeze he bach gyi h

/*
public class inheritance {
Run | Debug
    public static void main(String[] args){
        Vehicle obj1 = new Car();
        obj1.print();

        Vehicle obj2 = new Vehicle();
        obj2.print();
    }
}
class Vehicle{
    void print(){
        System.out.println("Base class(Vehicle)");
    }
}
class Car extends Vehicle{
    void print(){
        stem.out.println("Derived class(Car)");
    }
}
    //Note: Over ride hua aur function call hua toh child khudka function he chalega ->sub apna faeda dekhte h se yaad rakho
    output:Derived class(Car)
           Base class(Vehicle)

*/

/*
static varible ko directly class se bhi access kr skte h bina object bnaye
 */
//batao error kidher ayega?:
// class Test {
//     static int marks;

//     void set_marks(int marks) {
//         this.marks = marks; // Line 1
//     }
// }

// class OOPS {
//     public static void main(String[] args) {
//         Test t = new Test();

//         t.set_marks(98); // Line 2

//         System.out.print(Test.marks); // Line 3
//     }
// }
//answer :
//error ayega he nahi humara set_marks default type ka h isliye setter so aur sub line 1,2,3 valid syntax h

/*
output batao?
class Test {
    static int a = 10;
    static int b;

    static void changeB() {
        b = a * 3;
    }
}

class OOPS {
    public static void main(String[] args) {
        Test t = new Test();

        t.changeB();

        System.out.print(Test.a + Test.b);
    }
}

answer: --
         |
         v


40


*/
/*


1)Ab answer batao:
class Automobile {

    private String drive() {
        return "Driving vehicle";
    }
}

class Car extends Automobile {

    protected String drive() {
        return "Driving car";
    }
}

public class ElectricCar extends Car {

    @Override
    public final String drive() {
        return "Driving electric car";
    }

    public static void main(String[] wheels) {

        final Car car = new ElectricCar();

        System.out.print(car.drive());
    }
}
A. Driving vehicle
B. Driving electric car
C. Driving car
D. The code does not compile


answer : 

B yeh h answer



2)
a. Only protected can be used.
B. public and protected both can be used.
C. public, protected, and private can be used.
d. Only public can be used

// Shape.java

public class Shape {

    protected void display() {
        System.out.println("Display-base");
    }
}
// Circle.java

public class Circle extends Shape {

    <access-modifier> void display() {
        System.out.println("Display-derived");
    }
}


answer:

B. public and protected both can be used -> jo hota he h aur jo usse beheter h dono possible hote h access modifiers

3)
abstract class Car {

    static {
        System.out.print("1");
    }

    public Car(String name) {
        super();

        System.out.print("2");
    }

    {
        System.out.print("3");
    }
}

public class BlueCar extends Car {

    {
        System.out.print("4");
    }

    public BlueCar() {
        super("blue");

        System.out.print("5");
    }

    public static void main(String[] gears) {
        new BlueCar();
    }
}


A. 23451
B. 12354
C. 13245
D. The code does not compile.



answer:




C. 13245
*/

    }

}

class Pen{
    String color="red";
    int tip=5;
    void changeColor(String newColor){
        color=newColor;
    }
    void setTip(int newTip){
        tip=newTip;
    }
}

class BankAccount{
    public String userName="abc";
    private String password="123";
    public void setPassword(String newPassword){
        password=newPassword;
    }
    String getUserName(){ //yaha return type String he rahega 
        return this.userName; //.this keyword is used to refers to the current object
        //isko likhte he isliye h ki hume main function k ander function call krte time object na pass krna padhe
    }
    void setUserName(String newName){
        userName=newName;//we can write it like this also this.userName=userName; if the parameter was String userName not newName
    }
}
class Student{
    String name;
    int rollNo;


    //constructor
    // Student(){
    //     System.out.println("constructor is called...");
    // }


    //with parameters wala constructor:
    // Student(String name){
    //     this.name=name;
    // }


    //default constructor:-> yeh bnane ki jarurat hume ni h java khud bnaleta h yeh ager hum na banaye toh:
    //but wo jo bhi bnata h wo dikhta aese h constructor:
    // Student(){

    // }

    //types of constructor: 
    // 1. parameterized-> uper string name wala parameterized constructor tha
    // 2. non parameterized->  System.out.println("constructor is called..."); yeh print krne wala non parameterized tha
    // 3. copy constructor -> ek object ki cheezo ko dusre object mai dalna and use krna 

    //Note: ek class k ander bhut saare costructors bna skte h hum and requirement k hisab se wo wala he call hoga:
    // Student(){
    //     System.out.println("Hi you have called a constrctor..");
    // }
    // Student(String name){
    //     this.name=name;
    // }
    // Student(int rollNo){
    //     this.rollNo=rollNo;
    // }

    //ab ager mai isko delete krdu uper se:
    /*
    Student(){
        System.out.println("Hi you have called a constrctor..");
    }

    toh:
    Student s1=new Student();
    yeh wala main function ka code error dega 
    kyuki baki h constructors bne hue h jo faltu h:
    Student(String name){
        this.name=name;
    }
    Student(int rollNo){
        this.rollNo=rollNo;
    }
        
    but koe aesa constructor ni h jisme koe input na lena ho like:
    Student(){
        System.out.println("Hi you have called a constrctor..");
    }

    yeh wala so ab kyuki 
    Student(String name){
        this.name=name;
    }
    Student(int rollNo){
        this.rollNo=rollNo;
    }
    yeh kuch constructors pehele se he h class k ander toh default constructor ko java call ni kr payega 
    so conclusion: ki default constructor tabhi create hota h ager class k ander koe faltu constructor na ho
    toh hume 
    Student(String name){
        this.name=name;
    }
    Student(int rollNo){
        this.rollNo=rollNo;
    }
    inko bhi delete krna hoga!

    */

    /*
    ab note yaha yeh teeno constructors same class k they jisme kisi pr koe parameter ni tha,kisi pr 1,kisi pr 2, kisi pr 
    return type alag they toh isse kehete h ->constructor overloading.-> yaha hum polymorphism dekhre h mtlab multiple forms
    of a constructor dekhre h

    */

    /*
    ab isse dekhte h:
    // 3. copy constructor -> ek object ki cheezo ko dusre object mai dalna and use krna 

    
    
    */
    // String password;
    // Student(String name,int rollNo,String password){
    //     this.name=name;
    //     this.rollNo=rollNo;
    //     this.password=password;
    // }
    // Student(Student s1){
    //     this.name=s1.name;
    //     this.rollNo=s1.rollNo;
    // }


    //copy constructor ka disadvantage->yeh hota h shallow copy constructor 
    // int marks[];
    // String password;
    // Student(String name,int rollNo,String password){
    //     this.name=name;
    //     this.rollNo=rollNo;
    //     this.password=password;
    //     this.marks=new int[3]; 
    // }
    // Student(Student s1){
    //     this.name=s1.name;
    //     this.rollNo=s1.rollNo;
    //     this.marks=s1.marks;
    // }

    
    //deep copy:
    int marks[];
    String password;
    Student(String name,int rollNo,String password){
        this.name=name;
        this.rollNo=rollNo;
        this.password=password;
        marks=new int[3]; 
    }
    Student(Student s1){
        marks=new int[3]; //yaha ek naya 3 size ka array create kiya
        this.name=s1.name;
        this.rollNo=s1.rollNo;
        for(int i=0;i<3;i++){
            this.marks[i]=s1.marks[i]; //ab uss array mai s1 k marks array ki values ko dala toh ab jaise he object create hua
            //uske baad turant yeh recent values aa chuki h iss marks array m copy hoke ab ager hum object creation k baad
            //yani constructor call hoke ander k saare kaam ho jaane k baad ab uper s1.arr[0]=100; kre bhi toh kuch ni hoga
        }
        
    }


}



//Base class:
class Animal{
    String color;
    void breathe(){
        System.out.println("breathes..");
    }
    void eats(){
        System.out.println("eats..");
    }
}

//derived class or sub class or child class
// class Fish extends Animal{
//     int fins;
//     void swims(){
//         System.out.println("swims in water..");
//     }
// }

//multi level inheritance: base class on level 1:
// class Mammal extends Animal{
//     int legs;

// }
//multi level inheritance: base class on level 2:
// class Dog extends Mammal{
//     String breed="labrador retriver";
//     void changeBreed(String breed){
//         this.breed=breed;
//     }
// }


//hierarchichal inheritance base class 1:
class Mammal extends Animal{
    int legs;
    void walks(){
        System.out.println("walks..");
    }

}

//hierarchichal inheritance base class 2:
class Fish extends Animal{
    int fins;
    void swims(){
        System.out.println("swims in water..");
    }
}

//hierarchichal inheritance base class 3:
class Bird extends Animal{
    void flies(){
        System.out.println("flies..");
    }
}

class Calculator{
    int sum(int a,int b){
        return a+b;
    }
    float sum(float a,float b){
        return a+b;
    }
    double sum(double a,int b){
        return a+b;
    }
    float sum(int a,float b,float c){
        return a+b+c;
    }
    // return type same h float 2 methods k pr usse koe frk ni padhta same ho yaha alag
    //bss inn subme parameters alag h toh over loading hori h yaha

}

//Method overriding:
class Deer extends Animal{ //inherit krna bhi jaruri h tb hogi over riding
    void eats(){
        System.out.println("eats grass");
    }
}

abstract class Animals{
    String color;
    Animals(){  //yeh child classes se call hoga unka object bnte time 
        color="brown";
        System.out.println("inside animal constructor..");
    }
    
    void eats(){
        System.out.println("eats..");
    }
    abstract void walks(); //yaha idea diya h ki child class pr yeh func hona he chahiye and implement nahi hua h kuch
    //yeh line keheri h ki uska return type void he hona chahiye and name bhi same walks hona chahiye
}
class Horse extends Animals{
    Horse(){
        System.out.println("inside Horse constructor..");
    }
    void walks(){
        System.out.println("walks on 4 legs..");
    }
    void speed(){
        System.out.println("runs fastest..");
    }
    void changeColor(){
        color="dark bown";
    }
}
class Chicken extends Animals{
    Chicken(){
        System.out.println("inside Chicken constructor..");
    }
    void walks(){
        System.out.println("walks on 2 legs..");
    }
    void speed(){
        System.out.println("runs slow..");
    }
    void changeColor(){
        color="yellow";
    }
}

//inherits horse class
class Mustang extends Horse{
    Mustang(){
        System.out.println("constructor mustang..");
    }
}

//interfaces
interface ChessPlayer{
    void moves();//yaad rakho yeh public h and abstract bhi h kyuki koe implementation ni kr re hum yaha iska
}

class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("Up,Down,left,right");
    }
}

class King implements ChessPlayer{
    public void moves(){
        System.out.println("left, right");
    }
}

class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("Up, down");
    }
}


//multiple inheritance:
interface Herbivorous{
    void eats();
}
interface Carnivorous{
    void eats();
}
class Bear implements Herbivorous,Carnivorous{
    public void eats(){
        System.out.println("both.");
    }
}

//Oops question 1
//real+imaginary=4+3i
class ComplexNo{
    int i,r;
    ComplexNo(int i,int r){
        this.i=i;
        this.r=r;        
    }

    void add(ComplexNo c2){
        System.out.println("("+(this.r+c2.r)+"+"+(this.i+c2.i)+"i)");
    }
    void subtract(ComplexNo c2){
        System.out.println("("+(this.r-c2.r)+"+"+(this.i-c2.i)+"i)");
    }
    void multiply(ComplexNo c2){
        int real=(this.r*c2.r)-(this.i*c2.i);
        int imaginary=(this.r*c2.i)+(this.i*c2.r);
        System.out.println("("+real+"+"+imaginary+"i)");
    }
}

class Employee{
    static String company;
    String name;
    String eId;
    void setName(String name){
        this.name=name;
    }
    String getName(){
        return this.name;
    }
    void setEId(String eId){
        this.eId=eId;
    }
    String getEId(){
        return this.eId;
    }
    static float salaryOfThreeMonths(int a,int b,int c){ //yeh static function h logic same rahega isliye static he kr diya isse
        return (a+b+c)/3f; 
    }
}

class Parent{
    int age;
    Parent(){
        System.out.println("inside parent constructor..");
    }
    void greet(){
        System.out.println("hello my age is: "+age);
    }
    void salary(){
        System.out.println("my salary is 2.5 lakhs/month");
    }
}
class Child extends Parent{
    Child(){
        super(); //yeh likho na likho baat ek he h waise bhi constructor he call krta h yeh bs 
        super.age=45;
        super.greet();
        System.out.println("inside child constructor..");
    }
}
