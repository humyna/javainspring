=====ThreadLocal是什么=====
ThreadLocal为解决多线程程序的并发问题提供了一种新的思路。使用这个工具类可以很简洁地编写出优美的多线程程序。 
ThreadLocal，顾名思义，它不是一个线程，而是线程的一个本地化对象。
当工作于多线程中的对象使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程分配一个独立的变量副本。
所以每一个线程都可以独立地改变自己的副本，而不会影响其他线程所对应的副本。
从线程的角度看，这个变量就像是线程的本地变量，这也是类名中“Local”所要表达的意思。

=====ThreadLocal的接口方法=====
ThreadLocal类接口很简单，只有4个方法，我们先来了解一下。 
void set(Object value)
   设置当前线程的线程局部变量的值；
public Object get()
   该方法返回当前线程所对应的线程局部变量；
public void remove()
   将当前线程局部变量的值删除，目的是为了减少内存的占用，该方法是JDK 5.0新增的方法。
   需要指出的是，当线程结束后，对应该线程的局部变量将自动被垃圾回收，所以显式调用该方法清除线程的局部变量并不是必须的操作，但它可以加快内存回收的速度；
protected Object initialValue()
   返回该线程局部变量的初始值，该方法是一个protected的方法，显然是为了让子类覆盖而设计的。
   这个方法是一个延迟调用方法，在线程第1次调用get()或set(Object)时才执行，并且仅执行1次。ThreadLocal中的默认实现直接返回一个null。 
值得一提的是，在JDK5.0中，ThreadLocal已经支持泛型，该类的类名已经变为ThreadLocal<T>。API方法也相应进行了调整，新版本的API方法分别是void set(T value)、T get()以及T initialValue()。 


=====ThreadLocal是如何做到为每一个线程维护变量的副本的呢？=====
其实实现的思路很简单：在ThreadLocal类中有一个Map，用于存储每一个线程的变量副本，Map中元素的键为线程对象，而值对应线程的变量副本。
