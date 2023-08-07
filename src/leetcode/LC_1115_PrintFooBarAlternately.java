/**
1115. Print FooBar Alternately
Medium

Suppose you are given the following code:

class FooBar {
public void foo() {
for (int i = 0; i < n; i++) {
print("foo");
}
}

public void bar() {
for (int i = 0; i < n; i++) {
print("bar");
}
}
}
The same instance of FooBar will be passed to two different threads:

thread A will call foo(), while
thread B will call bar().
Modify the given program to output "foobar" n times.

Example 1:

Input: n = 1
Output: "foobar"
Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar().
"foobar" is being output 1 time.

Example 2:

Input: n = 2
Output: "foobarfoobar"
Explanation: "foobar" is being output 2 times.

Constraints:

1 <= n <= 1000
*/

package leetcode;

import java.util.concurrent.Semaphore;

public class LC_1115_PrintFooBarAlternately {
    private int n;
    private Semaphore s1 = new Semaphore(0);
    private Semaphore s2 = new Semaphore(0);

    public LC_1115_PrintFooBarAlternately(int n) {
        this.n = n;
        s1.release();
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            s1.acquire();
            printFoo.run();
            s2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            s2.acquire();
            printBar.run();
            s1.release();
        }
    }
}
