# 180825-TopCoder-Day4



## Graph?

* 그래프란 정점과 간선으로 표현되는 구조를 의미한다.

![](https://t1.daumcdn.net/cfile/tistory/2260D83F588074C822)

* 어떤 방향으로 움직여도 좋은 **무향 그래프**가 있고, 한 방향으로만 움직일 수 있는 **유향 그래프**가 있다.



## DFS, BFS

* 깊이우선, 너비우선 탐색방법이라고 한다.
* 다음 그림을 보며 이해를 빠르게 하자.

![](https://t1.daumcdn.net/cfile/tistory/2254723E588084F830)

* 두 탐색은 모든 정점을 한번만 방문한다는 같은 목표를 갖고 있지만, 그 과정에서 탐색하는 방식의 차이가 있다.
* DFS는  스택, 재귀함수로 구현할 수 있고, BFS는 큐, 리스트, 배열로 구현할 수 있다.
* 그러나 그중에서 가장 많이 사용하는 방법은 스택(DFS)과 큐(BFS)이다.
* 또한 구현에 있어 인접행렬과 인접리스트를 통해 구현할 수 있다.
* 만약, 간선마다 가중치가 있다면 거리가 짧은 순서로 탐색하는 방법을 '최고 우선 탐색' 이라고 한다.

---



## 다익스트라 알고리즘

* 하나의 정점에서 다른 모든 정점들의 최단 경로를 구하는 알고리즘

* 간선들은 모두 양의 간선들을 갖는다.

* 첫 정점을 기준으로 연결되어 있는 정점들을 추가해가며, 최단 거리를 갱신하는 것이다.

* 정점을 잇기 전까지는 시작점을 제외한 모든 정점들은 무한대 값을 갖는다.

* 즉, 시작점 거리값을 0으로 두고, 해당 목적지 까지 가는 가중치를 더한다. 

* 그 뒤, 무한대와 비교해서 무한대 값을 Min 값으로 대체하는 것.

* [다익스트라 알고리즘 설명](http://www.gisdeveloper.co.kr/?p=3881)
* [다익스트라 자바 구현](http://manducku.tistory.com/29)
* [다익스트라 자바 구현 2](http://bumbums.tistory.com/4)



## DFS 구현

* 깊이 우선 탐색은 가장 깊은 곳 까지 갔다가 다시 돌아와야 하기에, 스택이 가장 구현 하기에 적당하다.
* 스택에 깊이에 따라 노드를 추가해주고, 다시 올라올때는 이를 가장 최근에 더해진 노드를 스택에서 빼주면 되기 때문.
* 스택은 LIFO(Last in First out) 구조이기에 이러한 동작에 알맞다.



## BFS 구현

* 너비 우선 탐색은 DFS와 다음이 다르다.
  * 이전 정점으로 돌아올 필요가 없다.
  * 가까운 순서대로 탐색하므로, 나중에 발견한 정점은 나중에 탐색한다.
* 고로 메모리에 추가된 정점 중 오래된 것부터 차례대로 탐색해야한다.
* 우선 탐색을 시작하면, 가까운 모든 정점을 메모리에 넣는다.
* 그 후, 다음 정점으로 가서 탐색하고, 인접한 정점을 모두 메모리에 넣어준다. 
* 그러나, 인접한 정점 먼저 탐색하는 것이 아닌,  메모리에 저장된 순으로 탐색해준다.



## Stack 

* DFS에서 사용되는 자료 구조.
* 스택은 자료를 순서대로 저장하고, 가장 최근에 저장한 요소부터 출력해준다.

![](https://www.callicoder.com/assets/images/post/large/java-stack-data-structure.jpg)

## Queue

* BFS에서 사용하는 자료 구조.
* 자료를 순서대로 저장하고, 가장 먼저 저장한 요소부터 꺼내서 사용한다.

![](https://t1.daumcdn.net/cfile/tistory/25757B4556384E322B)

* FIFO(First In First Out) 구조



## Deque

* 덱은 Stack + Queue 같은 자료 구조를 말한다.
* 데이터 추가는 기본옵션, 먼저 추가한걸 뺄 수도, 가장 나중에 추가한 것을 뺄 수도 있다.

![](http://www.java2novice.com/images/dequeue.png)



## 재귀 함수

* 스스로를 호출하는 형태

* 가장 기초적인 피보나치 함수를 살펴 본다.

  ```java
  int fib(int a){
      if (a <= 1) return 1;
      retrun fib(a-2) + fib(a-1);
  }
  ```

* 그러나 이렇게 피보나치를 구현한다면 이런 접근 트리를 갖게된다.

  ![](https://theoryofprogramming.files.wordpress.com/2015/02/knap1.jpg?w=768&h=476)

  * 다음과 같이 구현한다면, fib(4)와 같은 동일한 계산구조가 두번이상 발생하는 경우가 발생하게 된다.

  * 그러므로, 이 계산 결과를 배열에 저장해서, 다음에 같은 계산이 발생하면, 배열에서 갖다 쓰게하여 좀 더 시간 복잡도를 낮출 수 있게 된다. 이를 Memoization이라고 한다.

  * Fibonacci의 경우, O(n^2)에서 O(n)으로 낮추는 것이 가능해진다.

  * Memoization을 통해 구현한 fib의 트리는 다음과 같다.

  ![](https://theoryofprogramming.files.wordpress.com/2015/02/knap2.jpg)

  * 이를 코드로 나타내면 다음과 같다.

    ```java
    int memo[100]; // memoization에 사용할 array
    int fibo(int n){
        if(n<=1){
            return n;
        }
        if (memo[n] > 0) return memo[n]; // n이 0보다 크면 이미 저장해두었던 값을 가져온다.
        memo[n] = fibo(n-1) + fibo(n-2);
        return memo[n]; // Memoization
    }
    ```

  * 다음과 같이 구하는 방법을 DP(Dynamic Programming)이라고 하며, 이 방법은 다음에 좀 더 자세히 다뤄보도록 하겠다.

  * 출처 

     [DP 설명 외국어 ver, 좀 더 친절히 잘 설명되어 있다.](https://theoryofprogramming.wordpress.com/2015/03/02/dynamic-programming-introduction-and-fibonacci-numbers/)

     [DP 설명](http://rath.tistory.com/38?category=646981)



# 구현 의사코드



##  재귀 함수를 이용한 DFS 구현

```java
int dfs(int now){
    if (현재 상태 now가 끝나는 조건) return 현재 상태 now의 값;
    int ret = -1;
    for(int i = 0; i < 다음 상태의 개수; i++){
        int next = i번째 다음 상태
        if(next가 조건을 만족하는 경우) ret = Math.max(dfs(next), ret);
    }
    return ret;
}
```



## Queue를 이용한 BFS 구현

```java
Queue<Integer> q = new LinkedList<Integer>();	
q.add(초기상태);
	while(!q.isEmpty()) {
		int now = q.poll(); // 큐의 head요소를 반환, 없으면 null 반환
		// 현재 상태를 처리한다.
		for (int i = 0; i < 다음 상태 개수; i++) {
			int next = i번째 다음 상태
			if(next를 방문했는가?) {
				q.add(next);
			}
		}
	}
```

---

## DFS와 BFS를 언제 사용하면 좋을까?

* DFS 
  * 모든 경로를 탐색하고, 결과를 확인해야 하는 경우
  * 문자열 등을 탐색할 때 " 사전 순서로 앞에 오는 것" 처럼 앞부터 검색해서 찾는 이 빠를 경우
* BFS
  * 시작 지점에서 가장 가까운 것을 구하고 싶은 경우
  * 탐색 범위 자체는 넓지만, 어느 정도 근처에 구하고 싶은 해가 존재하는 것을 알고 있는 경우
  * 탐색 범위가 굉장히 넓으며 깊이 우선 탐색을 사용할 때에는 스택이 대량으로 필요해지는 경우

---

## 08 고장난 로봇(p.148)

 * 이동패턴을 트리형태로 만들어 보면 어떨까?
 * 트리를 탐색할 때, 가지치기를 이용해서, 쓸데없는 것을 탐색하는데 드는 시간을 줄이자.
 * 앞으로는 DFS를 사용할 일이 많으니 이 코드를 잘 기억하자
 * 그리고 이 문제를 다시 BFS로 구현해보자.

*CrazyBot.java*

```java
package day4_0829;

public class Q8_CrazyBot {

	boolean[][] grid = new boolean[100][100];
	
	// east, west, south, north로 갔을 때의 좌표변화.
	int vx[] = { 1, -1, 0, 0 }; 
	int vy[] = { 0, 0, 1, -1 };

	double[] prob = new double[4];

	public double getProbability(int n, int east, int west, int south, int north) {
		
		// 각 방향으로 갈 확률을 저장해준다.
		prob[0] = east / 100;
		prob[1] = west / 100;
		prob[2] = south / 100;
		prob[3] = north / 100;

		// 한 가운데인 (50, 50)에서 시작한다.
		return dfs(50, 50, n); 
	}

	double dfs(int x, int y, int n) {
		if (grid[x][y])
			return 0; // grid[x][y]가 true면 이미 탐색이 된 것이다.
		if (n == 0)
			return 1; // 움직이는 횟수 0이면 확률은 무조건 1. 실패할 확률도 없으니까

		grid[x][y] = true; // 방문한 지점은 true로
		double ret = 0; // 성공할 확률 초기화
		for (int i = 0; i < 4; i++) {
			// east, west, south, north 순서로 로봇을 움직인다. 그리고 깊이 우선 탐색을 하여, 그 확률들을 모두 더해준다.
			ret += dfs(x + vx[i], y + vy[i], n - 1);
		}

		// grid[x][y] = false를 하는 부분은 현재의 탐색을 종료하며 나오는 부분이다. 
		// 즉, 다음 탐색을 하고자 마크했던 것을 제거하고 초기상태로 되돌리는 것.
		grid[x][y] = false;
		
		
		return ret;

	}

	public static void main(String[] args) {

	}

}

```
