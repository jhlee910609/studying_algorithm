# 회문(palindrome) 문제풀이

## 1. 회문의 정이

- 회문의 정의는 [링크](https://ko.wikipedia.org/wiki/%ED%9A%8C%EB%AC%B8)를 참고하면 된다.



## 2. 문제

- 문제는 아래와 같다.

![스크린샷 2018-05-03 오후 7.23.35](/Users/JunHee/Desktop/스크린샷 2018-05-03 오후 7.23.35.png)

![](/Users/JunHee/Desktop/스크린샷 2018-05-03 오후 7.23.52.png)

- 위 문제에서 중요한 조건들은 다음이다.
  1. 배열의 크기는 무조건 8 x 8이다. -> 상수
  2. 비교할 길이는 변수고, 앞으로 해도 `이효리` 거꾸로 해도 `이효리`를 찾는 문제.



## 3. 문제풀이 

```java
package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		System.setIn(new FileInputStream("src/res/input.txt"));
		Scanner sc = new Scanner(System.in);

		for (int testCase = 0; testCase < 10; testCase++) {
            
            // 1. 길이를 받는다.
			int length = Integer.parseInt(sc.next());
			char[][] map = new char[8][8];

			int resultCount = 0;

			// 2. 이차원 배열에 주어진 char들을 쪼개어 저장한다.
			for (int i = 0; i < 8; i++) {
				String temp = sc.next();

				for (int j = 0; j < 8; j++) {
					map[i][j] = temp.charAt(j);
				}
			}

            // 3. 하나씩 세어나간다.
			int row, col;

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {

					row = 0;
					col = 0;

				for (int k = 0; k < length / 2; k++) {
                    
					if (j <= 8 - length && map[i][j + k] == map[i][j + length - 1 - k])
							row++;

					if (i <= 8 - length && map[i + k][j] == map[i + length - 1 - k][j])
							col++;

						if (row == length / 2)
							resultCount++;

						if (col == length / 2)
							resultCount++;
					}
				}
			}

			System.out.printf("#%d %d\n", testCase + 1, resultCount);
		}
		sc.close();
	}
}
```

