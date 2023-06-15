# JavaExercises
Simple Java programs I found on an old hard drive.

**Language: Java**

**Start: 2013**

## Why
A few old simple Java programs I found on an old hard drive. Among them, two sorting algorithms and two intriguing calculations whose original source I have forgotten.

## calc_test1

The following calculation:

$$a_i = i \cdot i \cdot i$$

is performed in two different ways:

```java
private static void test1()
{
  for (int i = 0; i < a.length; i++)
    a[i] = i*i*i;
}

private static void test2()
{
  int i = 0;
  int c = 0;
  int k = 1;
  int m = 6;
  while (i < a.length)
  {
    a[i] = c;
    c = c + k;
    k = k + m;
    m = m + 6;
    i = i + 1;
  }
}
```

The second one is not straightforward but it can be proven to be the same:

$$a_i = c_{i - 1}$$

$$c_i = \sum_{j = 0}^i k_j$$

$$k_i = 1 + \sum_{j = 1}^i m_{j - 1}$$

$$m_i = \sum_{j = 0}^i 6 = (i + 1) \cdot 6$$

where _a1_, _c1_, _k1_, _m1_ are the values at the end of the first loop where _i_ is equal to 1. We can now write:

$$a_i = \sum_{j = 0}^{i - 1} k_j = \sum_{j = 0}^{i - 1} (1 + \sum_{l = 1}^j m_{l-1}) = \sum_{j = 0}^{i - 1} (1 + \sum_{l = 1}^j l \cdot 6) = \sum_{j = 0}^{i - 1} 1 + \sum_{j = 0}^{i - 1} \sum_{l = 1}^j l \cdot 6 $$

and since:

$$\sum_{j = 0}^{i - 1} 1 = i$$

$$\sum_{l = 1}^j l \cdot 6 = 6 \cdot \sum_{l = 1}^j l = 6 \cdot \frac{j^2 + j}{2}$$

we can write:

$$a_i = i + 6 \cdot \sum_{j = 0}^{i - 1} \frac{j^2 + j}{2} = i + 6 \cdot \sum_{j = 1}^{i - 1} \frac{j^2 + j}{2} = i + 3 \cdot \sum_{j = 1}^{i - 1} (j^2 + j)$$

we can simplify further the previous summation as follows:

$$\sum_{j = 1}^{i - 1} (j^2 + j) = \sum_{j = 1}^{i - 1} j^2 + \sum_{j = 1}^{i - 1} j =$$

$$= \frac{(i - 1)(i - 1 + 1)(2 (i - 1) + 1)}{6} + \frac{(i - 1)(i - 1 + 1)}{2} =$$

$$= \frac{i(i - 1)(2i - 1) + 3i(i - 1)}{6} = \frac{1}{3} (i^3 + i^2 - i^2 - i) = \frac{1}{3} (i^3 - i)$$

we can plug the simplified summation in the previous formula:

$$a_i = \bcancel{i} + \cancel{3} \frac{1}{\cancel{3}}(i^3 - \bcancel{i}) = i^3$$

