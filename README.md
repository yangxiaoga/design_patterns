# design_patterns
design patterns codes and notes

    Java

1、计算机语言的发展历史

机器语言 - 汇编语言 - 高级语言 

高级语言：
	面向过程：C Fortran PASCAL 
	面向对象：C++ JAVA C#
--------------------------------------
2、Java的核心优势
   跨平台，通过虚拟机做到
--------------------------------------
3、Java各版本

   J2EE:Java2 Enterprise Edition
   定位在服务器端的应用

    J2SE:Java2 Standard Edition
    定位在个人计算机的应用

    J2ME:Java2 Micro Edition
    定位在消费性电子产品的应用上
--------------------------------------
4、JDK
   java development kit Java开发工具包
  
   JRE
   java runtime environment
   java运行时环境

   JVM
   Java 虚拟机

   从上到下是包含关系

   JVM是一种规范
   是一个虚拟的用于执行bytecodes字节码的计算机
----------------------------------------
     
5、环境变量

   JAVA_HOME Java的安装目录

   PATH %JAVA_HOME%/bin

   CLASSPATH: java5.0 之后可以不进行配置


---------------------------------------
6、程序

   一个源文件可以有多个class
   一个源文件中至多只能有一个public的类声明，其它类的个数不限
  如果源文件中包含一个public类，源文件名必须和它中定义的public
  的类名相同，且以java为扩展名

  所以，一个java文件，编译之后，可以生成多个class文件
------------------------------------------------------
7、标识符

   【1】标识符必须以字母、下划线、美元符号开头，不能以数字开头
   【2】其他部分可以是字母，下划线，美元符号，和数字的任意组合
   【3】不能是关键字
   【4】大小写敏感，且无长度限制
   【5】不可以包含特殊字符如#
   
    Java内部采用了Unicode字符集，两个字节表示一个字符，共16位，2^16个状态 25536
    

    ISO8859-1--------BIG5
                |
                 --Unicode(UTF-8,UTF-16)
                |
                 --GB2312--GBK--GB18030

   
    ISO8859-1: 西欧字符集
    BIG5: 台湾的大五码，表示繁体汉字
    Unicode: 国际通用字符集
             西欧1个字节，阿拉伯等2个字节，中文3个字节
    GB2312: 大陆使用最早，最广的繁体中文字符集
    GBK:GB2312的扩展，可以表示繁体中文
    GB18030: 最新GBK的扩展，中国所有非手持/嵌入式计算机系统的
             强制实施标准，可以表示汉字，维吾尔文，藏文等中华
             民族字符

------------------------------------------------------------------

8、Java的数据类型

   数据类型---基本数据类型--数值型--整数类型-byte、short、int、long
           |       |              |
                                   --浮点类型-float、double
           |       |
                    -------字符型 char
           |       |
                    -------布尔型 boolean   
           |
            --引用数据类型-----类 class
                         |
                          -----接口 interface
                         |
                          -----数组 

  【1】整型
  byte：  1字节   -128-127
  short:  2字节   -2^15 - 2^15-1 -32768  32767
  int:    4字节   -2^31 - 2^31-1 约21亿
  long：  8字节   -2^63 - 2^63-1 

  十进制：10
  八进制：010
  十六进制：0x10 ,A B C D E F

   自动转型，数值默认为int
   int a = 10;
   long a1 = 200;
   byte a2 = 100;

   【2】浮点型
   
    float 4字节
    double 8字节

    十进制形式 3.14 314.0 0.314
    科学记数：314e2,314E2,314E-2(10^-2)
    浮点数数值默认为double类型，改为float类型，需要在后面增加F/f
    
    注意：浮点数存在舍入误差，很多数字不能精确表示，如果需要进行不产生
    舍入误差的精确数字计算，需要使用BigDecimal类,可以进行精确的计算

    最好避免比较重使用浮点数
    
    float f = 0.1f
    double d = 0.1/10;
    f!=d
  
   【3】char 字符型
    char类型用来表示在Unicode编码表中的字符
    每一个字符都对应一个数字a对应97
    char a = 'a';
    int i = a+2;
    char a1 = (char)i;
    
    循环打印a到z：

    char a = 'a';
    char c;
    int i;
  
    for(i=0;i<26 ;i++) {
      c = (char)(a + i);
      System.out.println(c);
    }

    char占16位，而且没有负值。所以最小值是0。最大值是1111111111111111 = 2^16 - 1
   
   【4】包装类
   需要将一个基本类型作为一个数来处理

   Integer 继承自Number 抽象类
   Integer.parseInt("xxx") 字符串转整型
   对象.intValue(); 基本类型 
  
   自动装箱 ：jdk5.0之后
   Integer i = 100;
   编译器为我们自动添加Integer i = new Integer(10);

   自动拆箱
   int c = new Integer(1500);
   编译器自动调用intValue()方法
   
   Integer 重写了equals方法 
   Integer a = 1234;
   Integer b = 1234;
   a.equals(b) true;
   a==b false
      
   Integer 对 【-128 - 127】之间的数，做了缓存，
   仍然当做基本数据类型处理
   
   【时间Date】

    java.util.Date
        java.sql.Date
        java.sql.Time
        java.sql.Timestamp

    标准纪元 1970.1.1 0点开始到某个时刻的毫秒数，类型是long
    
    java.text包 DateFormat和SimpleDateFormat

    完成字符串和时间的转化
    
    DateFormat是抽象类，只有一个子类SimpleDateFormat
    DateFormat df = new SimpleDateFormat(“yyyy-MM-dd hh:mm:ss”)
    Date d = new Date(21213232L);
    String format = df.format(d);
		
    String string = "1978-23-21 10:10:10";
    DateFormat dFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
    Date date2 = (Date) dFormat1.parse(string);
    System.out.println(date2);

    【Calendar】

    long类型数和日期的转化

    实现类：GregorianCalendar日历，月份从0开始：一月是0，二月是1，,1月是11
                                   周日是1...周六是7
    Calendar c = new GregorianCalendar();
    c.set(2001,1,10,12,23,34);
    Date d = c.getTime();
    long l = c.getTimeInMillis();
    System.out.print("date:"+d+" "+l);
    >> date:Sat Mar 10 12:23:34 CST 2001 984198214876
   
    c.set(2001,1,10,12,23,34)中 0代表1月，1代表2月
    c.setTime(new Date());设置时间
    日期计算
    c.add(Calendar.YEAR,-30); 减三十年

------------------------------------------------------------------------------
  【4】boolean类型
   不是一个字节，而是一位

  【5】自动类型转换

   容量小的数据类型可以自动转换为容量大的 数据类型
   容量的大小指的是所表示的数的范围，而不是字节数如long可以转换为float
   
   表达式中的类型提升问题


----------------------------------------------------------------------------
9、变量

 Java是一种强类型语言，每个变量必须声明去类型
 Java比那粮食程序中最基本的存储单元 ，其要素包含变量名，变量类型和作用域

 变量：成员变量（类成员）、局部变量（方法成员）

 局部变量必须先声明及初始化
 
 常量只能被初始化一次，通常全部用大写字母
-------------------------------------------------------------------------------
10、运算符

instanceof 是否是一个类的实例
条件运算符:  ? :

~ : 取反，如~8，即8的补码为01000，取反后为10111，则原码为11000+1 = 11001，即-9

& : 按位与，如4:0100,8:1000，按位与为0

| : 按位或

^ : 按位异或

<< : 左移运算符,相当于*2； 如a<<2 相当于3*2*2
>> : 右移运算符,相当于/2取商；如b>> 相当于12/2/2 

---------------------------------------------------------------------
11、debug模式

-----------------------------------------------
12、方法method
    
    递归：调用自己，并规定什么时候不调用了

13、包
    包和包之间没有包含关系，只是逻辑上看起来有关系
    java主要的包
    java.lang Java语言的核心类如String,Math,Integer,System,Thread提供常用功能
    java.awt 包含了构成抽象窗口工具类
    java.net 网络相关操作的类
    java.io 包含提供多种输入输出功能的类
    java.util 包含一些实用工具类，如日期先关函数
     
14、API
    常用的java注释标签
    @Author 坐着
    @Version 版本
    @param 参数
    @return 返回值的含义
    @throws 抛出异常面熟
    @deprecated 废弃

15、键盘输入

    Scanner类 构造器 new Scanner(System.in)
    调用next()方法，程序运行时会阻塞，等待键盘的输入


-------------------------------------------------------------
16、面向对象

    【1】面向对象编程的三大基本特征：
         封装、继承、多态

    面向过程：方法，变量多，很难上手，需要捋流程

    类 - 类似于C语言中结构体的概念
    抽象成类，管理成本降低，扩展性更好

    面向对象把握整体，面向过程把握细节

   【2】面向对象的本质
         以类的形式组织代码，以对象的方式组织（封装）数据
   【3】对象 具体的事物
   【4】类 是对对象的抽象

     先有具体的对象，然后抽象各个对象之间象的部分，归纳出类
     通过类再认识其他对象
     
     Java语言中除了基本变量外，都是引用变量

   【5】对象的默认值
     
      引用类型都是null
      数字0，小数为0.0
      boolean 默认为false
      char 默认为\u0000
    
      Java中方法参数传递：值传递

    【6】堆和栈
       栈：放置局部变量
       堆：放置new出的对象

       方法区：也是堆的一部分，放置类的信息，static变量，常量池（字符串常量）等

       虚拟机看到一个类，则看是否加载该类，没有去classpath下找，找到就加载，类加载器ClassLoader
       加载后就在方法区中有了该类的信息

    【7】面向对象的三大特征
         
       1、继承：某一批类的抽象，从而实现对现实世界更好的建模
             提高代码的复用性
             关键字extends

             子类继承父类，可以得到父类的全部属性和方法（除了父类的构造方法）
             java的多继承可以通过接口实现

             子类中可以根据需要对从基类中继承来的方法进行重写override
 
             重写的方法必须和被重写方法具有相同方法名称、参数列表和返回类型

             重写方法不能使用比被重写方法更严格的访问权限

             Object是类体系中的根，Ctrl+T 查看父类

       关键字super
            super是直接父类对象的引用，可以通过super来访问父类中被子类覆盖的方法或者属性
            在普通方法中没有顺序限制，可以随便调用
      
            在构造函数中，任何类的构造函数中，弱势构造函数的第一行代码没有显示调用super
            Java默认都会调用super，作为父类的初始化函数
    

       2、封装
          隐藏对象内部的复杂性，对外公开简单的接口，便于外界调用，从而提高系统的可扩展性，可维护性
           
          程序设计的追求:高内聚，低耦合
          高内聚：就是类的内部数据操作细节自己完成，不允许外部干涉
          低耦合：仅暴露少量的方法给外部使用


          访问控制符
                      同一个类          同一个包         子类        所有类
           private      *
           default      *                  *
           protected    *                  *              *
           public       *                  *              *            *


       3、多态
        
          编译和运行    编译 - 实际   
          继承+方法重写+父类引用指向子类对象
       
          如果是父类的方法(子类未进行重写)调用子类重写的方法，
          那么最终调用的是子类重写的方法，因为this指向的就是当前的对象
      
    【8】抽象类
     
         有抽象方法的类只能定义成抽象类
         抽象类不能实例化，不能用new实例化抽象类
         抽象类可以包含属性，方法，构造方法，当时构造方法不能用来new实例，只能让子类调用
         抽象类只能用来继承
         抽象方法必须被子类实现
   
         抽象类的一般方法，可以调用抽象方法，因为抽象类不能一般形式的实例化
         但是子类可以，子类实现了抽象方法
  
    【9】接口
 
         接口中只有常量和抽象方法
         接口不能创建实例，但是可用于声明引用变量类型
         一个类实现了接口，必须实现接口中所有的方法，并且这些方法只能是public的
         接口支持多继承

    【10】回调
  
         一部分代码不知道怎么实现，用别人来做
         方法的参数为某一类
         public void draw(Frame f) {
                xxxxxxxxxx;
                f.pain();
                xxxxxxxx;
         }

         MyFrame extends Frame{}

    【11】内部类
           
          普通内部类：可以看做是外部类的一个普通成员，需要先有外部类，后有普通内部类

          实例：Face.Nose nose = new Face().new Nose();

          静态内部类
          当一个静态内部类对象存在，并不一定存在
          对应的外部类对象，因此静态内部类的实例方法
          不能直接访问外部类的实例方法

          静态内部类看做外部类的一个静态成员
          外部类的方法可以通过静态内部类.名字访问静态内部类的静态成员
          实例：Face.Inner inner = new Face.Inner();

    【12】引用的分类
          强引用，GC运行时不回收
          软引用，gc运行时可能回收，jvm内存不够
          弱引用，gc运行时回收
          虚引用，无引用

          例：弱引用
          String str = "弱引用";
          WeakReference<String> wr = new WeakReference<Stirng>(str);
          System.out.println("gc运行前："+ wr.get());
          str = null;
          System.gc();
          System.runFinalization();
          System.out.println("gc运行后："+ wr.get());
          
          常量值得对象不能回收
          如果是new String("xxx");
          发现已经被回收

          WeakHashMap 键为弱类型，gc运行立即回收
          WeakHashMap<String,String> map = new WeakHashMap<String,String>();

          IdentifyHashMap<String,String> map = new IdentifyHashMap<String,String>（）；
          只比较地址，如果地址不同，才视为key不同

          EnumMap 键只能为枚举的值

          EnumMap<Season,String> map = new EnumMap<Season,String>(Season.class);
           

-----------------------------------------------------------------------------------------------------
17、垃圾回收机制

垃圾回收器将负责回收所有不可达对象的内存空间
程序员无权调用垃圾回收器
程序员可以通过System.gc(),通知GC运行，但是Java规范并不能保证立刻运行
finalize方法是Java提供给程序员用来释放对象或资源的方法，但是尽量用

18、构造方法
构造器用于构造这个类的示例
如果我们没有定义构造器，则系统会自动定义无参构造函数，如果已定义，则编译器不会添加

19、重载

    普通方法可以重载，构造方法也可以重载
   
   【1】规范
    同一个类，同一个方法名
    不同：参数列表不同（类型，个数，顺序不同）
     
20、static关键字

  static声明的成员变量为静态成员变量，或者叫做类属性，类变量
  他为类的公共变量，属于类，被该类的所有实例共享，在类被载入时，被显式初始化
  对于该类的所有对象来说，static 成员变量只有一份，被该类的所有对象共享。

  一般使用类名.类属性调用

  static声明的方法为静态方法
    不需要对象，就可以调用
   在调用该方法时，不会将对象的引用传递给它，在static方法中不可以访问非static的成员

   通过this调用其他构造方法，必须位于第一句如this(a,b)


21、final关键字

    修饰变量 - 常量
    修饰方法 - 该方法不能被子类重写，但是可以被重载
    修饰类 - 不能有子类，不能被继承，如Math,String



----------------------------------------------------------------
22、数组

    相同数据类型的有序集合
    数组有默认值如int：0
    
    数组的快速复制：System.arraycopy(src,start,dest,dsetStart,length);start为下标

    数组的操作类：java.util.Arrays();

                   asList（）列表
                   binarySearch(a,12)二分排序；low,high,mid high=toIndex-1
                   toString()数组元素输出
                   冒泡排序：依次比较，最终将最大的冒出来，交换算法
                   


23、字符串String
    Java字符串就是Unicode字符序列
    存储 final char[] value
   
    StringBuilder
    线程不安全，效率高，默认长度为16的字符数组
    扩容：新的长度*2+2
  
    StringBuffer
    线程安全，效率低
    
 --------------------------------------------------------------------------

24、File

    java.io.File 文件或者目录的抽象表示形式
    路径分隔符：File.separator   

    mkdirs() 不存在则创建

递归打印文件目录树结构
public static void printFile(File file, int level) {
	for(int i=0; i <level; i++) {
		System.out.print("-");
	}
	System.out.println(file.getName());
	
	if(file.isDirectory()) {
		File[] files = file.listFiles();
		for(int j =0; j<files.length; j++){
			printFile(files[j], level+1);
		}
	}
}

---------------------------------------------------------------------------------

25、异常Exception

    体系结构

    java.lang.Object
      -- java.lang.Throwable
          -- Error 不需要程序员处理
          -- java.lang.Exception
            -- java.lang.RuntimeException
            -- checked Exception


    Error和RuntimeException统称为未检查异常   

    常见异常 NullPointerException
             InterruptedException
             IOExcetpion
             FileNotFoundException
             ClassNotFoundException
             ClassCastException
             ArrayIndexOutOfBoundsException
             NormatFormatException

             
     try、catch、finally关键字

     finally无论是否异常，都会执行       
     异常处理的代码执行结束后，是不会回到try语句去执行尚未执行的代码        
      
     越是顶层的异常类越往后放

     try catch finally return的执行顺序
     
     执行try catch语句，给返回值赋值，但是并没有立即返回
     执行finally
     return
     
     finally中不要使用return语句 

     throws：谁调用谁处理

     方法重写中的异常
     子类声明的异常范围不能超过父类声明
         父类没有声明异常，子类也不能
         不可能抛出原有方法抛出异常类的父类或上层类，可以抛出RuntimeException及其子类
         不能抛出其他除了父类抛出异常范围内的非RuntimeException
     

     抛出异常 throw new Exception

-------------------------------------------------------------------------------------------

26、容器
   
     Collection表示一组对象，它是集中，收集的意思，就是把一些数据收集起来

     Collection函数库是java.util包下的一些接口和类
     类时用来产生对象存放数据用的，而接口是访问数据的方式

     Collection和数组的不同
     数组容量有限制，而Collection没有这样的限制，容量可以自动调节
     Collection只能用来存放对象，而数组没有这样的限制

     Collection接口是根接口，定义了一些最基本的访问方法
     
     【1】Collection类体系

     Collection
        |
         ---- Set 无序不可重复
        |     |
               ---HashSet    
        |
         ---- List 有序可重复   

     Map 键值对
      |
       ---- HashMap  
    
       

      【2】Collection方法
          int size()
          boolean isEmpty()
          boolean contains(Object o)
          Object[] toArray();
          boolean add(E e)
          boolean remove(Object o) 
          boolean containsAll(Collectin<?> c) 是否包含c中所有的元素  
          boolean addAll(Collection<? extends E> c)
          boolean removeAll(Collectin<?> c) 移除c中与this中相同的元素
          boolean retainAll(Collectin<?> c) 取交集，即移除this中两者不同的元素
          void clear() 清空
          boolean equals(Object o)
          int hashCode()

       【3】List
            

            E list.get(0) 返回具体下标对应的对象    
            E set(int index, E element) 返回值是旧的值，如果为空列表，则会抛出IndexOutOfBoundsException异常
            E remove(int index) 返回被删除的值

            ArrayList底层实现是数组，便于查找，修改，插入，删除慢，线程不安全
            LinkedList底层实现是链表，查找慢，便于修改，插入，删除，线程不安全
            Vector顶层实现是数组，并且是线程安全的，效率低
            
        ArrayList 数组的实现
    
        LinkedList链表的实现 
        
      【4】Map
           java.util
           Map用来存储键值对，键值不能重复
           Map接口的实现类有HashMap和TreeMap
           
             
            Object put(Object key, Object value);
            Object get(Object key);
            Object remove(Object key);
            boolean containsKey(Object key);
            boolean containsValue(Object value);
            int size();
            boolean isEmpty();
            void putAll(Map map);
            void clear();


            HashMap 效率高，线程不安全
            Hashtable 效率低，线程安全

            Map底层实现：数组+链表
               
                         每个数组指向一个对象：Entry,Entry成链表
           
            hashCode有可能会得到负值，对整数取余，可能是负值

            如何储存Map

            HashMap与Hashtable
            HashMap线程不安全，键最多一个null，值可以为多个null，父类AbstractMap
            Hashtable线程安全，键与值都不能为空，父类Dictionary

            Properties 键与值都只能为字符串
            
              App.class.getResourceAsStream("相对路径")
              当路径以/开头是从classpath根下获取，
              Class.getClassLoader().getResourceAsStream("相对路径")
              默认从classpath根下获取，path不能以/开头

            Thread.currentThread().getContextLoader().getResourceAsStream("路径");

            第一：前面有 “   / ” 

           “ / ”代表了工程的根目录，例如工程名叫做myproject，“ / ”代表了myproject 

           第二：前面没有 “   / ” 

           代表当前类的目录 



      【5】Set集合
           
           接口，无序不可重复

           HashSet
           TreeSet
           
           依赖HashMap来实现，add方法，元素位置就放在key处
           
       TreeSet数据元素可以排序，且不可重复
       TreeSet是在添加数据时排序，数据更改不会影响原来的顺序
       因此在TreeSet使用的过程中，不要修改set中的数据，否则可能重复

       Set接口：HashSet元素必须重写HashCode和equals方法
       
       去重：比较等于0即去重

       TreeMap 确保key可以排序


     【6】遍历Iterator接口
        
            hasNext 是否cursor等于size()

     【7】Collections工具类

          reverse 元素翻转
          shuffle 模拟洗牌
          swap（list,i,j）元素交换

     【8】队列 Queue
      队列，通常FIFO先进先出
      
      插入、移除、获取

      
           
----------------------------------------------------------------------------
27、泛型

    泛型就是参数化类型，使用广泛的类型
    在编译时检查类型安全
    所有的强制转换都是自动和隐式的
    泛型必须为引用类型

   
    1、泛型类
     
    class 类名<字母列表> {

        修饰符 字母 属性
        修饰符 构造器(字母) { }
        修饰符 返回类型 方法(字母){ }
    }

      对于泛型类：泛型是在使用时确定的，不能使用静态属性或者方法上，
      因为后者是编译时确定的
    
      常见： T type类型 K V key value, E element ? 不确定
    ------------------------------------------------------

    2、泛型接口：

       public interface Comparator<T> { 
         void compare(T t);
       }
       对于泛型接口：泛型字母不能使用在全局常量上
    -----------------------------------------------------
    3、泛型方法
   
       修饰符 <字母> 返回类型 方法名(字母) {

       }
       字母在修饰符的后面，返回类型的前面

       public class AAA {
           public static <T> void test(T t) {}
           public static <T extends Closeable> void test1(T... t) {
               for (T temp: t)  {
                   temp.close();
               }
           }
       }
       在方法内部，t对象的信息只能访问，不能修改
   --------------------------------------------
    4、泛型擦除，父类为泛型类

       public abstract class Father<T,T1> {
            T name;
            public abstract void test(T t);
       }
       

       几种不同的子类

      【1】子类指定具体的类型,即声明时使用具体类型
           子类的属性则为具体类型，方法同理


       class Child extends Father<String, String>{
           
           //继承自父类的name也是字符串类型
          String t2;

           @Override
           public void test(String t) {}  
       }
     
      【2】子类为泛型类

       class Child<T,T1> extends Father<T,T1>{
           
           T t;

           @Override
           public void test(T t) {}  
       }
       字母的顺序可以调换
     
       
      【3】子类为泛型类，父类不指定类型

       class Child<T1, T2> extends Father{
           
           //这里继承来的name也是Object类型

           @Override
           public void test(Object t) {}  
       }
       
       以上为泛型的擦除,统一使用Object替换

  
      【4】子类父类同时擦除
      
       class Child extends Father{
           
           //这里继承来的name可以使用具体的类型，也可以使用Object

           @Override
           public void test(Object t) {}  
       }

      【5】错误情况
       父类指定泛型时，子类不能擦除，
      【原则】要么同时擦除，要么子类大于等于父类的类型，即子类包含父类的泛型或父类擦除
       

       --------------------------------
       属性的类型决定：如果父类中，随父类而定
                       如果在子类中，随子类定
       重写方法中类型，随父类而定
       
       使用时，擦除，不会类型检查
       如Student stu = new Student(); 【Student是泛型类】
       public static void test(Student<Integer>);
       可以将stu作为参数
       ------------------------------------
       接口也是一样的道理
       
      【6】泛型？的使用

       泛型没有多态
       如 A<Fruit> a = new A<Apple>()是错误的


       ？不能用在类上，只能在声明的时候使用
       如：
       public static void test(Student<?> stu){

       }

       上限
       public static void test(Student<? extends Fruit> stu){

       } 
       下限
       public static void test(Student<? super Fruit> stu){

       } 

      【7】泛型的嵌套
       A<Student<Fruit>> a = new A<Student<Fruit>>();

      【8】没有泛型数组
      【9】JDK7改进
           声明时指定泛型即可，创建对象不用再次编写类型
           A<String> a = new A<>();
           

      增强的for循环，需要实现Iterable接口的iterator方法

-----------------------------------------------------------------------------
   28、   排序算法

      冒泡，选择，插入，shell，堆
      public static void sort(int[] arr) {
		int N = arr.length;
		if (N == 0) {
			return;
		}
		
		for (int i = 1; i < N; i++) {
			for(int j = 0; j < N - i; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
   


----------------------------------------------------------------------------
引用类型的排序
    实现 java.lang.Comparable
    方法public int compareTo(Object obj)
   
    返回0 表示 this == obj
    返回正数 表示 this > obj
    返回负数 表示 this < obj

    整数、小数、Integer、Float、Double直接比较基本数据类型的大小
    字符：比较unicode码之差
    字符串：
      如果其中一个是另一个的子串，则返回长度之差
      否则，返回第一个不相等的unicode码之差

    排序

    推荐使用【1】，可以解耦
    【1】Collections.sort(list, new 比较规则类());
     比较规则类需要实现Comparator接口

	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		return 0;
	}

      【2】或者类自身实现 Comparable接口

	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
-----------------------------------------------------
集合的同步控制

ArrayList,HashSet,HashMap都是线程不安全的
Collections提供了synchronizedXxx()将制定的容器包装成同步
synchronizedList()
synchronizedSet()
synchronizedMap();

不可变设置：只读访问
emptyXxx();
emptyList();
singletonXxx() 一个元素不可变的集合
List<String> list = Collections.singletonList(new String());
试图在list中添加元素，会抛出，不被支持的操作异常

unmodifiableXxx（）不可变容器



------------------------------------------------------------------
29、IO流

  File类 文件和目录抽象的表示形式

  File.pathSeparator 路径分隔符  windows为；
  File.separator  名称分隔符 windows为\




  相对路径：/开头
  绝对路径：盘符开头

  构建File对象
  File(String parent, String child) 如：File("E:/xp/test","1.jpg");
  File(File parant,String child) 如：File(new File("E:/xp/test"), "1.jpg");
  
  File(String name) 如：File("E:/xp/test/1.jpg");//绝对路径构建

  没有盘符，以user.dir构建
  File f = new File("text.txt")//以当前工作空间构建

  File类方法
  getPath（）//如果是绝对路径，返回绝对路径，否则相对路径
  getAbsolutePath() //返回绝对路径
  getParent() //返回上一级目录，如果是相对的，返回null

  exists（）//是否存在
  canRead() //是否可读
  canWrite() //是否可写
  
  isFile() //是否是文件
  isDirectory() //是否是文件夹

  isAbsolute() //是否为绝对路径

  length（）//长度，字节数；若是文件夹则长度为0
  
  File f = new File("xx"),boolean f.createNewFile(); //创建文件，如果文件存在，则创建失败
  
  
  File f = new File("xx/parent/test"), f.mkdir();//创建目录，确保xx/parent存在
  File f = new File("xx/parent/test"), f.mkdirs();//创建目录，如果xx/parent不存在，则一同创建

  f.listFiles(); //如果是目录，列出子目录或文件


  文件名称过滤器的使用【命令模式的体现】：

	public static void testFile() {
		File file = new File("C:/Program Files/Java/jdk1.8.0_221");
		if (file.isDirectory()) {
			File[] list = file.listFiles(new FilenameFilter() {
				
				//名称过滤器，需要为文件，并且后缀为zip
				public boolean accept(File dir, String name) {
					return new File(dir,name).isFile() && name.endsWith(".zip");
				}
			});
			
			for(File temp : list) {//打印过滤后的文件名称
				System.out.println(temp.getName());
			}
		}
	}



30、IO的原理及概念

  流：流动，流向，从一端移动到另一端，有源头及目的地
  程序与文件间的操作|数组|网络连接|数据库，以程序为中心



IO流的分类体系

  1、流向：输入流，输出流
  2、数据：字节流，可以处理一切文件，包括纯文本，doc,音频，视频等等
           字符流，处理文本文件，纯文本
  3、功能：节点流，包裹源头
           处理流，增强功能


  字符流与字节流

  字节流
  InputStream 输入流   read(byte[] b)，close()
      FileInputStream
    
  OutputStream 输出流  write(byte[] b),flush()刷新写出,close();
      FileOutputStream (File file,boolean append)
        如果append是true表示追加，否则覆盖
      字符串转byte数组
      byte[] b = str.getBytes()

  字符流
  输入流 Reader read(char[] cbuf),close();
         FileReader


  输出流 Writer read(char[] cbuf),flush(),close();
         FileWriter

  功能：
       节点流：Reader Writer，InputStream,OutputStream

       处理流：字节，BufferedInputStream； 字符BufferedReader,readLine();
               字节，BufferedOutputStream；字符BufferedWriter,newLine()换行

       处理流都是套在节点流上 
       如 InputStream bis = new BufferedInputStream(new FileInputStream(new File("xxxx")));
          OnputStream ois = new BufferedOnputStream(new FileOnputStream(new File("xxxx")));


      转换流
      字节流转换为字符流
        输出流 OutputStreamWrier(OutputStream,charset)
        输入流 InputStreamReader(InputStream,charset)


      如：BufferedReader reader = new
           BufferedReader(
             new InputStreamReader(
               new FileInputStream(new File("xxx")
             ,"UTF-8") 
           )
          )
      解码：二进制 - 字符，编码字符集
      编码：字符 - 二进制，解码字符集
      


             
                                  
          FileInputStream                                         FileReader   
          ------------------     
                                                                                                                                                解码                             
          -------------------               InputStreamReader     |   File   | 
          |    File         |          ---------------------- >                            
          -------------------                                                 
                                                                  BufferedReader    
  
          BufferedInputStream                                           
  


                             
                                         
          FileOutputStream                   编码                                                            FileWriter  
        
                                     OnputStreamWriter             
     					                                          File   
       |    File         |        ---------------------- >         
                                                   
       BufferedOnputStream                                         BufferedWriter   

文件拷贝
    static void fileReader() {
    	InputStream iStream = null;
    	OutputStream oStream = null;
    	byte[] buffer = new byte[10];
    	try {
    		iStream = new FileInputStream("C:/Users/Administrator/Desktop/java.txt");
    		oStream = new FileOutputStream("C:/Users/Administrator/Desktop/temp.txt", false);
    		
    		@SuppressWarnings("unused")
			int length;
			while ((length = iStream.read(buffer)) != -1) {
    			oStream.write(buffer);
    		}
    		oStream.flush();
    		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try{//关闭流
				if (oStream != null) {
					oStream.close();
				}
				if (iStream !=null) {
					iStream.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
    	
    }


文件夹的拷贝

	/**
	 * 文件夹的拷贝 
	 */
	
	public static void folderCopy(File origin, File destination) {
		if (origin == null || destination == null){ return; }
		if (origin.isDirectory()) {//源头为目录
			destination.mkdirs();//确保目标路径存在
			
			for (File son : origin.listFiles()) {
			    folderCopy(son, new File(destination, son.getName()));
			}

		} else {//源头是文件，直接拷贝
			
			if (destination.isDirectory()) {//目标是目录
				destination = new File(destination, origin.getName());
			}
			fileCopy(origin, destination);
		}
		
	}



   节点流
      字节数组，字节，节点流
      
       byte[] src = "xxxx".getBytes();
       InputStream is = new InputStream(new ByteArrayInputStream(src));
       ByteArrayOutputStream bos = new ByteArrayInputStream();
       String str = "xxx";
       byte[] info = str.getBytes();
       bos.write(info,o,info.length);
       bos.toByteArray();

  基本数据类型处理流

      输入流 DataInputStream,   readInt(),readDouble(),readCharr()
      输出流 DataOutputStream,  writeInt(),writeDouble...
      
  引用类型
     序列化：ObjectOutputStream ,保存
     反序列化: OjbectInputStream ,读取
     需要实现 java.io.Serializable
     不需要序列化的属性：transient修饰
     
  数组也可以序列化，和反序列化


  打印流 PrintStream
  System.out
   
   File f = new File();
   ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(f)));
   ps.println("xxxx")

   三个常量：in，out, error
  
   Scanner,处理流

文件的分隔与合并


    装饰设计模式
      说白了就是组合


    类与类之间的关系：
       依赖：形参|局部变量
       关联：属性
               聚合：整体与部分，不一致的生命周期，如：人与手
               组合：整体与部分，一致的生命周期，如：人与大脑
       继承：父子类关系
       实现：接口与实现类关系


--------------------------------------------------------
31、多线程

  程序：指令集，静态概念
  进程：操作系统调度程序，动态的概念
  线程：在进程内，多条执行路径
  
  真正的多线程：多个CPU,多核
    CPU时间片，A时间片执行A代码，没执行完，挂起，执行B时间片，
    来回的切换

 【1】进程
  资源分配的单位
  程序的一次动态执行过程，占用特定的地址空间
  每个进程都是独立地，由3部分组成：CPU,DATA,CODE
     
 【2】线程
  调度和执行的单位
  进进程中，单一的连续控制流程/执行的路径
  线程之间相互独立
  一个进程可拥有多个并行的线程
  共享相同的内存单元/内存地址空间
  每个线程有独立地运行栈和程序计数器，线程切换的开销小

  
 【3】实现多线程
  继承Thread接口
  实现Runnable接口
   
  
 【4】Callable接口
  可以返回值，可以对外抛出异常

  重写call方法
  
  
/**
 * 解决Thread无返回值，无发抛出异常
 */
public class ThreadCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
	ExecutorService service = Executors.newFixedThreadPool(2);//二个线程
		
	Race rabbit = new Race("乌龟", 3000);
	Race tortoise = new Race("兔子", 1000);
		
	Future<Integer> rabbitResult =  service.submit(rabbit);
	Future<Integer> tortoiseResult = service.submit(tortoise);
        
	Thread.sleep(10000);
	rabbit.setFlag(false);
	tortoise.setFlag(false);
		
	int num1 = rabbitResult.get();
        int num2 = tortoiseResult.get();
        System.out.println(rabbit.getName()+"跑了："+ num1 +"步");
        System.out.println(tortoise.getName()+"跑了："+ num2 +"步");
        service.shutdown();//停止
    }
}

/**
 * 实现Callable接口
 */
class Race implements Callable<Integer> {
	private String name;
	private int time;
	private boolean flag = true;
	private int steps = 0; //步数
	public Race(){}
	public Race(String name, int time){
		this.name = name;
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public Integer call() throws Exception {
		while(flag) {
			Thread.sleep(time);
			steps++;
		}
		return steps;
	}
}
   
【5】线程的状态

                 阻塞解除   
                  ------
                 |      |
                       阻塞
        阻塞解除 |      | 
                          导致阻塞的事件
                 |      |
   创建-start()- 就绪 - 运行 - 终止,死亡状态
 新生状态        挂起 

 
【6】停止线程

 自然终止：线程体正常执行完毕

 外部干涉：
    线程类中定义线程体使用的标识 - flag
    线程体使用该标识
    提供对外的方法，改变该标识

  
 【7】阻塞 

  join 合并线程，t.join();

  yield 暂停当前正在执行的线程对象，并执行其他线程
  Thread.yield();在谁的线程体中，就暂停谁
  
  sleep:暂停当前线程，休眠时，不会释放锁

        应用在和时间相关的，比间隔多长时间，打印一次，
              模拟网络延时

  
  【8】方法
    isAlive（） 判断状态
    getPriority() 优先级 默认为5；
    setPriority() 概率不是绝对的优先级
    setName()
    getName()
    currentThread() 当前线程

    
  【9】线程的同步
   多个线程访问同一份资源，确保资源的安全和正确
   对其加入同步，称为线程安全

   synchronized 

   同步块 
   synchronized（引用类型|this|类.class）{

   }

   同步方法

    经典：单例模式中的double-check

    
   【10】死锁
    过多的同步容易死锁
  
    wait释放锁
    sleep不释放锁

    notify（）、notifyAll()

package com.ethan.design.java.thread;

public class Movie {
	
	private String pic;
	
	/**
	 * flag为true时，生产者生产，消费者等待，生产完成后，通知消费
	 * 否则，消费者消费，生产者等待，消费完后，通知生产
	 */
	private boolean flag = true;
	
	public Movie(String pic) {
		this.pic = pic;
	}
	
	public synchronized void  play(String s) throws InterruptedException {
		if (!flag) {//生产者等待
			this.wait();
		}
		Thread.sleep(500);
		//生产完毕
		this.pic = s;
		System.out.println("生产了："+pic);
		//通知消费
		this.notify();
		//生产者停下
		this.flag = false;
		
	}
	public synchronized void watch() throws InterruptedException {
		if(flag) {
			this.wait();
		}
		//开始消费
		Thread.sleep(500);
		System.out.println("消费了："+pic);
		//观看完,通知生产
		this.notifyAll();
		//消费停止
		this.flag = true;
	}

}

package com.ethan.design.java.thread;

public class Player implements Runnable{
	
	private Movie movie;
	
	Player(Movie movie) {
		this.movie = movie;
	}

	public void run() {
		for(int i=0; i<20; i++) {
			if (i%2 == 0) {
				try {
					movie.play("左边青龙！");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}else{
				try {
					movie.play("右边白虎！");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}



package com.ethan.design.java.thread;

public class Watcher implements Runnable{
	
	private Movie movie;
	
	public Watcher(Movie movie){
		this.movie = movie;
	}

	public void run() {
		for(int i=0;i <20;i++) {
			try {
				movie.watch();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}

package com.ethan.design.java.thread;

/**
 * 生产者，消费者 
 * 先生产，再消费
 */
public class ProviderConsumer {
	public static void main(String[] args) {
		Movie movie = new Movie("Smooth");
		Thread t1 = new Thread(new Player(movie));
		Thread t2 = new Thread(new Watcher(movie));
		t1.start();
		t2.start();
	}

}


    【11】任务调度
     java.util.Timer

     schedule(TimerTask,Date)
     schedule(TimerTask,Date firstTime, long period)
    
    Timer timer = new Timer();
    TimerTask task = new Task();
    //任务，第一次执行，间隔
    timer.schedule(task, 1000, 1000);

    TimerTask是一个实现Runnable接口的抽象类


    第三方，任务调度框架Quartz
    


  --------------------------------------------------

  32、Annotation注解

  注解是从JDK5.0开始引入的新技术

  Annotation的作用
   不是程序本身，可以对程序做出解释 - 跟注释类似
   可以被其他程序如编译器获取，注解信息处理流程

 Annotation在哪里使用
   可以附加在package,class,method,field上边

  
  内置注解@Override ,@Deprecated @SuppressWarning
  
  自定义注解，元注解
  public @interface Override{}
  

  元注解
   
  @Target(ElementType.METHOD) 应用在哪里
  @Retention
  @Documented
  @Inherited

  @Target 的取值范围:
      ElementType.METHOD
      ElementType.FIELD
      ElementType.METHOD
      ElementType.PACKAGE 等
      ElementType.TYPE 类，接口，枚举
      ElementType.LOCAL_VARIABLE 局部变量

  
  @Retention
   描述注解的生命周期
   RetentionPolicy.SOURCE 在源文件中有效
   RetentionPolicy.CLASS 在class文件中有效
   RetentionPolicy.RUNTIME 在运行时有效


  ORM ObjectRelationMapping

  对象关系映射
  面向关系的存储

  Java动态性值反射机制reflection

  反射机制
    指的是，可以于运行时加载，探知，使用编译期间完全未知的类
    Class.forName（“xxx”）；

  动态语言
      程序运行时，可以改变程序结构或变量类型
      如python，ruby,javascript

   C,C++,JAVA不是动态语言，但是Java有一定的动态性
   我们可以利用反射机制，字节码操作获得类似动态语言的特性

   
   【Class】
    代表正在运行的java类或接口
    每一个类都会生成一个Class对象

    对象是表示或者封装数据的，一个类被加载后，类的整个结构信息会
    放到对应的Class对象中，

    同样一个类只会被加载一次，一个类只对应一个Class对象

   【Class的获取】
    类.class
    Class.forName()
    对象.getClass();
    int.class 基本数据类型也可以获取Class对象
    new int[10].getClass();//不同类型的数组的Class对象不同

   【反射机制的常见作用】
   
    Class clazz;
    clazz.getName();包括包名+类名
    clazz.getSimpleName();获得类名


    clazz = (Class<Student>) Class.forName(path);
			
    /** 返回声明为public的属性 */
    Field[] fileds = clazz.getFields();
			
    /** 返回所有属性 */
    clazz.getDeclaredFields();
    Field field = clazz.getDeclaredField("name");
		
    /** 获取方法 */
    clazz.getMethods();//public
    clazz.getDeclaredMethods();//all
    Method m = clazz.getDeclaredMethod("setName", String.class); //方法名，参数类型
			
			
    /** 获得构造方法的信息 */
    clazz.getDeclaredConstructors();//all constructors
			
    /** 通过Class构造实例对象 */
    Student student = clazz.newInstance();//调用午餐构造方法，若没有午餐构造函数，则出现初始化错误异常
    Constructor<Student> constructor = clazz.getDeclaredConstructor(String.class, int.class);
    Student stu =constructor.newInstance("我是通过构造方法构造的", 20);
    System.out.println(stu.getName());
		    
    /** 通过反射调用方法 ,m为setName*/
    m.invoke(stu, "改变之后的姓名")	;
    System.out.println(stu.getName());
            
    /** 设置属性 */
    field.setAccessible(true);
    field.set(stu, "直接操作属性修改后的结果");
    System.out.println(stu.getName());
    


   ---------------------------
  field.setAccessible(true); 不需要做访问的安全检查

  安全检查是比较耗时的 

  --------------------------------------------------

  33、动态编译

      场景：客户在浏览器编写Java代码，上传服务器编译和运行
            服务器动态加载某些类文件进行编译

      动态编译的两种做法：
          通过Runtime调用javac,启动新的进程去操作

          Runtime run = Runtime.getRuntime();
          Process process = run.exec("javac -cp d:/myjava/ Hello.java");
           
          通过JavaCompiler动态编译

          import javax.tools.JavaCompiler;
          import javax.tools.ToolProvider;
          main{ 
              JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
              int result = compiler.run(null,null,null,"c:/my/Hello.java");
              System.out.println(result);//0编译成功，非0编译失败
          }

--------------------------------------
34、Java脚本引擎从JDK6.0引入

  Java脚本API是连通Java平台和脚本语言的桥梁

  可以把一些复杂异变的业务逻辑脚背脚本语言处理，提高开发效率

  ScriptEngineManager man = new ScriptEngineManager();
  ScriptEngine engi = man.getEngineByName("javascript");  //js引擎Rhino，集成到了JDK6.0

	public static void useScriptEngine() throws ScriptException, NoSuchMethodException, IOException {
		ScriptEngineManager manager = new ScriptEngineManager();
		
		ScriptEngine engine = manager.getEngineByName("javascript");
		//定义变量，会存储到引擎上下文中
		engine.put("msg", "这是个常量");
	    String script = "var user = {name:'养',age:18,schools:['1','2']};";
	    script += "print(user.name);";
	    engine.eval(script);//养
		engine.eval("msg='update to new value';");
		System.out.println(engine.get("msg")); //update to new value
		
		/** 定义函数 */
		engine.eval("function add(a,b){var sum = a + b;return sum;}");
		/** 执行方法 */
		Invocable invoke = (Invocable)engine;
		Object result = invoke.invokeFunction("add", 1,2);
		System.out.println("相加结果："+result);
		
		/** 执行JS脚本文件 */
		URL url = ScriptEngineUsing.class.getClassLoader().getResource("engine.js");
		Reader reader = new FileReader(url.getPath());
		Object resultJS = engine.eval(reader);
		System.out.println("调用脚本相加结果："+resultJS);
		reader.close();
	}


--------------------------------------------------------
35、Java字节码操作

    实现的功能：
        动态生成新的类
        动态改变某个类的结构（添加，删除，修改 新的属性，方法）
    优势：
       比反射开销小，性能高
       javasist性能高于反射

    字节码操作类库：

        BCEL byte code engineering library apache jakarta项目的一部分

        ASM 轻量级的java字节码操作框架，直接涉及到JVM底层的操作和指令

        CGLIB Code Generation Library
        强大的，高性能，高质量的Code生成类库，基于ASM实现

        javassist 日本东京大学开发
            开源的分析，编辑，和创建Java字节码的类库，性能较ASM差，跟cglib差不多
        但是使用简单，很多开源框架都在使用它

        Aspect Oriented Programming
        
        javassist can be a good tool for adding new methods into a class
        and for inserting before after around advice at the both caller and callee sides.

        javassist API主要由CtClass,CtMethod,CtField构成，

         
         局限性：
         不支持注解修改
         不支持数组初始化，如String[]{"a","b"}，除非只有数组的容量为1
         不支持内部类和匿名类
         不支持continue和break表达式
         
--------------------------------------------------------
36、类加载过程

 
    加载 - 链接 -初始化

【加载】
    将class文件字节码内容加载到内存中，并将这些静态数据转换成
    方法区【特殊的堆】中运行时数据结构，在堆中生成一个代表这个类的java.lang.Class对象
    作为方法区类数据的访问入口，这个过程需要类加载器参与
    
     java.lang.Class -  - - - - - -> 方法区【静态变量，静态方法，常量池，类的代码】

【链接】
    将Java类的二进制代码合并到JVM的运行状态之中的过程

  验证
    确保加载的类信息符合JVM规范，没有安全方面的问题
  准备
    正式为类变量static分配内存，并设置类变量初始值，这些内存都将在方法区中进行分配，
    包括static{ }块


  解析
    虚拟机常量池内的符号引用直接替换为引用的过程，即抽象到具体

【初始化】

   
     执行类构造器<clinit>()方法的过程
     编译器自动收集，所有类变量的赋值动作和静态语句块的语句合并产生的

     父类没有初始化的，则先初始化其父类

     访问Java类的静态域时，只有真正声明这个域的类才会被初始化


  类加载和初始化只有一次

  1、new时会发生初始化，
  2、引用常量也会初始化
  3、但是使用常量并不会初始化类
  4、通过反射，加载，也会初始化

  5、通过类的数组，不会被初始化
  6、通过子类去访问父类声明的静态域时，子类不会被初始化，父类才会被初始化 

 --------------------------------------------------


  类加载器的层次结构

  引导类加载器 bootstrap class loader
   用来加载java核心库 jre/lib/rt.jar或sun.boot.class.path路径下的内容
   是用原生代码来实现的，并不继承java.lang.ClassLoader
   
   加载扩展类和应用程序类加载器，并制定他们的父类加载器

  扩展加载器
    用来加载java的扩展库 jre/ext/*.jar或java.ext.dirs路径下的内容
    java虚拟机的实现会提供一个扩展库目录，该类加载器在此目录里面查找并加载java类

    由sun.misc.Launcher$ExtClassLoader实现

   应用程序类加载器application class loader
      根据java应用的类路径classpath,java.class.path

      一般来说，java应用的类都是由它来完成加载的

     由sun.misc.Launcher$ApplicationClassLoader实现

   自定义类加载器
     开发人员可以通过继承java.lang.ClassLoader类的方式
     实现自己的类加载器



  类加载器的代理模式

  交给其他加载器来加载指定的类

  双亲委托机制
    父加载器优先加载，父类不能则，在让子类加载
    保证用户不会出现定义与java类库同名的类及包


 OSGI 面向java的动态模块系统，为开发人员提供了面向服务和基于组件的运行环境

 ---------------------------------------------------
 正则表达式

 
     \n 换行
     \t 制表符
     \\ \本身
     
     \d :任意一个数字，0-9
     \D :非数字
     \w :任意一个字母，或数字，或下划线，A-Z, a-z,0-9，_.
     \W :除了字母，数字，下划线

     \s :包括空格，制表符，换行符，等空白字符的其中任意一个
     \S :非空白符号的其他字符
     . : 小数点可以匹配任意一个字符，不能匹配一个换行符
 
    
    【自定义字符集合】

     []方括号匹配方式，能够匹配方括号中任意一个字符

     [ab5@] ：配置a,或b,或5，或@
     [^abc]： 匹配 a,b,c之外的任意一个字符
     [f-k]：  匹配f-k之间的任意一个字符
     [^A-F0-3]：匹配A-F,0-3之外的任意一个字符


     特殊符号包含到[]则，失去特殊意义
     如[\d.\-+], .就表示一个.,如果需要，则得转义

     
     【量词】修饰匹配的次数

     {n}  :表达式重复n次 ,如\d{6}，\d\d{6}【七位】(\d\d){6}【12位】
     {m,n}:表达式至少重复m次，最多重复n次 ,非贪婪模式：匹配3次就好，\d{3,6}?
     {m,} :表达式至少重复m次
       ？ ：匹配表达式0次或者一次，相当于{0,1}，如 ：a\d?b,数字出现0或者1次
       +  : 表达式至少出现一次，相当于{1,}
       *  :表达式不出现或出现人任意次，相当于{0，}


    【字符边界】

     ^ : 与字符串开始的地方匹配  如：^i，以i开始
     $ : 与字符串结束的地方匹配  如：i$, 以i结尾
    \b : 匹配一个单词边界。左右不全是\w表示



     多行模式，每一行都是一个字符串，都有开头和结尾

     在多行模式下，只匹配开头或者结尾
     \A：单行 \Ai，以i开头
     \Z：单行 i\Z，以i结尾

    【选择符和分组】
     
    | ：左右两边表达式之间或关系，匹配左边或者右边，如：gao|zhang
   （）：捕获组，每一个括号会分配一个编号.反向引用： ([a-z]{2})\1，找到的内容如gogo,toto,dodo
   （?：Expressin）:非捕获组.加个?：，捕获组会进行存储，耗资源 (？：[a-z]{2})

   【预搜索（零宽断言）】
    (?=exp) :断言自身出现的位置的后面能匹配表达式exp
    (?<=exp) :断言自身出现的位置的前面能匹配表达式exp
    (?!exp) : 断言此位置的后面不能匹配表达式exp 
    (?<!exp):断言此位置的前面不能匹配表达式exp

     [a-z]+(?=ing):  going , doing eating,匹配到的是do,do,eat

     
   【电话号码的匹配】
    固话+手机号

    (0\d{2,3}- \d{7,9}|1[35789]\d{9})

    邮箱

    
    [\w\-]+@[a-z0-9A-Z]+(\.[a-zA-Z]{2,4}){1,2}    .com.cn重复两次
    

