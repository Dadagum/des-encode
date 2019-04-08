# Des加密算法

## 使用

```java
byte[] text = {...};
byte[] pk = {...};
byte[] encoded = Des.encode(text, pk); // 得到加密后结果
```

## 设计思路

1. 主要在于对比特串进行抽象，可以看到算法中需要对64位的明文和56位的密文分成两半，然后明文、密钥或者是明文和密钥分成的两半都需要进行一些置换，移位，异或等等的操作，如何设计呢？

   - 一个比特串分成两半，那么看成两份比特串，因此都可以将它们抽象成为比特串。

   - 定义BitString接口，表示一个比特串，并定义比特串操作相关的方法。
   - SimpleBitString实现了BitString接口，内部实际上是byte数组。
   - CombinedBitString也实现了BitString接口，内部实际上是两个SimpleBitString，方便划分左右两半并进行相关的操作。而Text和PrivateKey为了代码更加理解并且可以定制明文和密钥的一些特有方法，故都继承自CombinedBitString类。

2. 一切的操作都可以看作比特串BitString的操作，具体一些有区别的实现只需要实现接口的方法不同即可。