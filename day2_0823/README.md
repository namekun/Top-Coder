## 180823 TopCoder day2

## 전체탐색

* 모든 패턴을 조사해야 하는 것과 그것을 필요로 하는 문제

*InterstingParty.java*

```java
	public int bestInvitation(String[] first, String[] second) {
		int ans = 0;

		for (int i = 0; i < first.length; i++) {
			int fir = 0;
			int sec = 0;
            // first와 second 모두 자기 자신과 비교하고, 그 다음에 다른 배열과 비교한다.
            // 두번씩 비교해줘서, 인원수를 모두 체크할 수 있도록 한다.
			for (int j = 0; j < second.length; j++) {
				if (first[i].equals(first[j]))
					fir++;
				if (first[i].equals(second[j]))
					sec++;
				if (second[i].equals(first[j]))
					fir++;
				if (second[i].equals(second[j]))
					sec++;
			}

			ans = Math.max(ans, fir);
			ans = Math.max(ans, sec);
		}

		return ans;
	}
```

---

## 연관 배열(associative array)

배열에 접근할때, 인덱스 값으로 접근하는 것이 아니라, 문자열을 이용해서 접근하는 법

### 자바에서는 HashMap으로 사용한다.

HashMap이란 Map인터페이스의 한종류로써 Key와 Value 값으로 데이터를 저장하는 형태를 가지고 있다. 

![HashMap](https://t1.daumcdn.net/cfile/tistory/2725663856821E6F0C)

* Map은 키(Key) , 값(Value) 을 하나의 쌍으로 묶어서 저장하는 컬렉션 클래스들을 구현하는 데 사용 된다. 쉽게 말해 key, value 값으로 저장하는 List 형태의 조상이라고 생각 하시면 편하다. Map에 종류에는 Hashtable, HashMap, LinkedHashMap, SortedMap, TreeMap 등이 있다. 역시 이들 객체들 또한 key, value로 데이터를 저장하게 된다. 

* 해싱(hashing)이란 검색 방법을 사용하기 때문에 많은 양의 데이터를 검색하는데 있어서 뛰어난 성능을 보여준다. HashMap에서 한가지 주의 할 점은 map에 데이터를 등록할 때 , key값은 중복이 되지 않고 , value값은 중복이 허용된다는 점이다. 예를들어, 

```java
map.put("호랑이" , "힘90") 
map.put("여우" , "힘90") 
map.put("호랑이" , "힘80") 

//(최종 호랑이 key에 저장된 value는 "힘80"으로 나중에 입력된 key의 value로 덮어 씌어 집니다.)   
```

이런형태로 key 값이 중복 되어선 안된다는 점이다. 하지만 value값 ("힘90")은 중복을 허용한다. 다시말해 key값을 컬렉션 내의 유일한 key여야 하고, value값은 같은 값이 여러개가 있어도 상관없다.

*HashMapExample.java*

```java
public class TestHashMap {

	public static void main(String[] args) {
                   // HashMap에 Data 넣기 (Key , Value) 형태  
		HashMap<String , Integer> map = new HashMap<String , Integer>();
		map.put("김태희", new Integer(90));
		map.put("전혜빈", new Integer(80));
		map.put("유인나", new Integer(100));
		map.put("아이유", new Integer(90));
		
                // HashMap에 포함된 Key 중에 "유인나"라는 키를 가질 경우 true 리턴 (없을 경우 false) 
		if(map.containsKey("유인나")){
			System.out.println("유인나 최고");
		}
		
                // HashMap에 포함된 Key , Value를 Set에 담고 iterator에 값을 Set 정보를 담아 준다.  
		Set<Entry<String, Integer>> set = map.entrySet();
		Iterator<Entry<String, Integer>> it = set.iterator();
		
                // HashMap에 포함된 key, value 값을 호출 한다. 
		while (it.hasNext()) {
			Map.Entry<String, Integer> e = (Map.Entry<String, Integer>)it.next();
			System.out.println("이름 : " + e.getKey() + ", 점수 : " + e.getValue());
		}
		
                // Map에서 저장된 Key들을 가져올 Set을 만든다.  
		Set<String> set2 = map.keySet();
		System.out.println("참가자 명단 : " + set2);
		
		// Map에 저장된 value값들 Collection<Interger> 형태로 얻어 오고 iterator에 담는다.   		Iterator<Integer> it2;
		Collection<Integer> values = map.values();
		it2 = values.iterator();
		
		int total = 0;
		
		while (it2.hasNext()) {
			Integer i = (Integer)it2.next();
			total += i.intValue();
		}
		

                // 결과 출력  
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (float)total/set.size());
		System.out.println("최고점수 : " + Collections.max(values));
		System.out.println("최저점수 : " + Collections.min(values));
	}
}
```

*HashMapExampleResult*

```
유인나 최고
이름 : 김태희, 점수 : 90
이름 : 유인나, 점수 : 100
이름 : 아이유, 점수 : 90
이름 : 전혜빈, 점수 : 80
참가자 명단 : [김태희, 유인나, 아이유, 전혜빈]
총점 : 360
평균 : 90.0
최고점수 : 100
최저점수 : 80
```

* 다음은 HashMap의 Method들이다.

**생성자  메서드**

-**설명** 

* **HashMap()**

  \- HashMap 객체를 생성

  ex)

  ```java
  HashMap<String , Integer> map = new HashMap<String , Integer>();
  Map<String, Integer> map = new HashMap<String, integer>();
  ```

* **HashMap(int initlalCapacity)**

  \- 지정된 값을 초기 용량으로 하는 HashMap객체를 생성한다.

  HashMap(int initlalCapacity, float loadFactory)

  \- 지정된 값을 초기용량과 load factory의 HashMap 객체를 생성한다. 

* **HashMap(Map m)** 

  \- 주어진 Map에 저장된 모든 요소를 포함하는 HashMap을 생성한다. 

* **void clear()**

  \- HashMap에 저장된 모든 객체를 제거한다. 

  ex) map.clear();

* **Object clone()**

  \- 현재 HashMap을 복제하여 반환한다. 

  ex) newmap  =  (HashMap)map.clone();

* **boolean containsKey(Object Key)**

  \- HashMap에 지정된 키(Key)가 포함되어 있는지 알려준다. 

* **boolean containsValue(Object Value)**

  \- HashMap에 지정된 값(Value)가 포함되어 있는지 알려준다. 

* **Set entrySet()**

  \- HashMap에 저장된 Key - Value갑슬 엔트리(키와 값을 결합)의 형태로 Set에 저장하여 반환

  ex) 

  ```JAVA
    map.put("A", 1);
    map.put("B", 2); 
    map.put("C", 3); 
    Set set = map.entrySet();
    System.out.println("set values are" + set);
    (result) set values : [A=1,B=2,C=3]
  ```

* **Object get(Object Key)**

  \- 지정된 Key 의 값을 반환한다. 

  ex) 

  ```java
    map.put("A", 1);
    map.put("B", 2);
    map.put("C", 3);
    String  val =  (String)map.get("B");
  ```

  System.out.println("Value  for key B is: "  +  val); 

  (result)  Value  for key B is 2

* **bloolean isEmpty**

  \- HashMap이 비어있는지 확인한다.

  ex)  boolean  val =  map.isEmpty();

* **Set keySet()**

  \- HashMap에 저장된 모든 키가 저장된 Set을 반환한다.

  ex) 

  ```java
    map.put("A", 1);
    map.put("B", 2);  
    map.put("C", 3);
    Set keyset = map.keySet();
    System.out.println("Key set values are" + keyset);
    (result) Key set values are [A,B,C]
  ```

* **Object put(Object Key, Object Value)**

  \- HashMap에 키와 값을 저장.

  \- HashMap에서 key값에 해당하는 값을 찾아서 Value값을 넣는다.

  ex) 

        map.put("A", "aaa");
        map.put("B", "bbb");
        map.put("C", "ccc");

* **void putAll(Map m)**

  \- Map에 해당하는 모든 요소를 HashMap에 저장한다. 

  Object remove(Object Key)

  \- HashMap에서 지정된 키로 지정된 값을 제거한다.

  ex) map.remove("key");

* **int size()**

  \- HashMap에 저장된 요소의 개수를 반환한다. 

* **Collection values()**

  \- HashMap에 저장된 모든 값을 컬렉션 형태로 반환한다. 

출처: [http://arabiannight.tistory.com/entry/자바Java-자바-HashMap-이란](http://arabiannight.tistory.com/entry/%EC%9E%90%EB%B0%94Java-%EC%9E%90%EB%B0%94-HashMap-%EC%9D%B4%EB%9E%80)

---

## Q2 암호

* 생각한것.

  * 기존의 입력 배열중, 1개의 수를 택하고, 이를 제외한 나머지 숫자와 모두 곱한다. 
  * 택한수는 + 1을 해주고, 아까 나온 결과와 곱한다.
  * 이를 반복문으로 돌려서 배열에 넣어주고, `Math.max`함수로 최대값을 구하여 리턴한다.

  ```java
  import java.util.*;
  // 내 코드 더럽넹
  	public long encrypt(int[] numbers) {
  		long ans = 0;
  		int[] gop = new int[] {1,1,1};
  
  		for (int i = 0; i < numbers.length; i++) {
  			int chNum = 0;
              // 기존의 값에 + 1을 해준다.
  			chNum = numbers[i] + 1;
  
  			for (int j = 0; j < numbers.length; j++) {
  				// 곱한걸 gop 배열에 저장을 한다.
                    gop[i] *= numbers[j];
  			}
  			
  			gop[i] /= numbers[i]; // 개중에 값이 변한걸 나누고
  			gop[i] *= chNum; // 그자리에 변한 숫자를 곱해준다.
  		}
  
  		for (int i : gop) {
  			ans = Math.max(ans, i);
  		}
  
  		return ans;
  	}
  ```

  * 중복 `for`문 1개, 일반 for문 1개.. 더러운데

  *TopCoderAnswer1,깔-끔*

  ```java
  	// Top Coder 해설
  	public long encryptAns1(int []numbers) {
  		long ans = 0;
  		
  		for (int i = 0; i < numbers.length; i++) {
  			long temp = 1;
  			for (int j = 0; j < numbers.length; j++) {
  				if(i == j) {
  					temp *= (numbers[j] + 1);
  				} else {
  					temp *= numbers[j];
  				}
  			}
  			ans = Math.max(ans, temp);
  		}
  		return ans;
  	}
  ```

  * 어느 숫자에 + 1을 해도 증가율은 (n+1)/n이다. 
  * 고로 최소값에 +1 해주는게 증가율이 제일큼;

  *TopCoderAnswer2, 어차피 어떤것을 비교해도 최소값에 +1하는게 좋다는 것을 알았을 경우*

  ```java
  	// Top Coder 응용 기술
  	// 사실 그냥 증가치가 가장 큰것은 최소값에 + 1하는것.
  	public long encryptAns2(int []numbers) {
  		long ret = 0;
  		Arrays.sort(numbers);
  		numbers[0]++;
  		for (int i : numbers) {
  			ret *= i;
  		}
  		return ret;
  	}
  ```

---

## Q3에 들어가기 앞서 ArrayList

java는 collection FrameWork이라고 하는 자체적인 라이브러리 안에 ArrayList라는 데이터 스트럭쳐를 만들어 두었기에 직접적으로 우리가 할 이유는 없다.

* 생성

```java
ArrayList<Integer> numbers = new ArrayList();
//<>- generic이 뭐지?
```

---

### 토막상식 Generic

* 왜 사용하는가?
  * 타입의 안정성을 제공, 타입체크와 형변환을 생략할 수 있어, 코드가 간결해진다.
* 왜 string, int 대신에 String, Integer을 사용하는가?
  * `<generics>`에 선언할 수 있는 타입이 객체 타입이어야 하기 때문에 `int`,`string`와 같은 기본자료형은 들어갈 수 없다. 그래서 `String`,`Integer`와 같은 Wrapper클래스를 사용한다. 
  * Wrapper클래스는 기본형 변수들에 기능을 좀 더 추가해서 객체화 시킨 클래스들을 말한다. 

---

* ArrayList는 java.util.ArrayList에 속해있기에, import를 해줘야한다.

```java
import java.util.ArrayList;
```

* element를 추가할 때는 `add`메소드를 사용한다. 단순히 배열에 더해지는 것이라 빠르게 동작한다.

```java
numbers.add(10);
numbers.add(20);
numbers.add(30);
numbers.add(40);
```

![](https://s3.ap-northeast-2.amazonaws.com/opentutorials-user-file/module/1335/2888.png)

* 특정 위치에 추가하고싶다면, 메소드의 add의 인자로 인덱스를 지정한다.

```java
numbers.add(1,50);
```

![](https://s3.ap-northeast-2.amazonaws.com/opentutorials-user-file/module/1335/2889.png)

* 자바의 배열의 크기는 고정 되어있다. 데이터를 추가하는 과정에서 내부적으로 사용하는 배열이 꽉차면 기존의 배열 대비 크기가 2배 큰 새로운 배열을 만들고 기존의 데이터를 새로운 배열로 복제한다. 덕분에 프로그래머는 ArrayList의 크기에 신경쓰지 않고 편리하게 프로그램을 만들 수 있다. 하지만 배열의 크기를 키움과 동시에 많은 부하가 발생하는데, 이런 기능은 List 데이터 스트럭쳐의 본질적인 기능이라고 할 수 없다.

* 특정 idx에 위치하는 엘리먼트를 삭제할 때는 remove

```java
numbers.remove(2);
```

![](https://s3.ap-northeast-2.amazonaws.com/opentutorials-user-file/module/1335/2890.png)

* 특정 index값을 이용해서 해당하는 value값을 가져올땐 get을 사용합니다.

```java
numbers.get(2);
```

![](https://s3.ap-northeast-2.amazonaws.com/opentutorials-user-file/module/1335/2891.png)

* .size() 메소드를 통해서 ArrayList에 들어있는 객체의 수를 리턴할 수 있다.

```java
numbers.size();
```

---

### 반복

자바에서는 ArrayList를 탐색하기 위한 방법으로 iterator을 제공한다. 

* iterator 

  * 자바의 컬렉션 프레임워크에서 컬렉션에 저장되어 있는 요소들을 읽어오는 방법중 하나이다. 
  * iterator객체는 객체 내부에 저장된 값을 하나씩 순회하면서 탐색할 수 있도록 돕는 객체이다.
  * Iterator는 interface이고, 그 구성은 다음과 같다.

  ```java
  public interface Iterator {
  
  boolean hasNext();//메소드가 읽어 올 요소가 남아있는지 확인하는 메소드
     				// 있다면 true, 없다면 false를 return
  Object next(); // 다음 요소를 가져온다.
  void remove();// next()로 읽어 온 요소를 삭제한다. next()를 호출한 다음에
      		// remove()를 호출해야한다.
  
  }
  ```

* 생성은 다음과 같습니다.

  ```java
  Iterator it<Integer> = numbers.iterator();
  ```

* .next() 메소드를 호출할때마다, 엘리먼트를 순서대로 리턴한다. 더 이상 순회할 엘리먼트가 없다면, .hasNext()의 값은 false가 되며 while문이 종료될 것이다.

  ```java
while(it.hasNext()){
    System.out.println(it.next());
}
  ```

* 순회 과정에서 필요에 따라 엘리먼트를 삭제, 추가하는 작업을 해야만 한다. 그런 경우 아래와 같이 처리한다.

  ```java
  while(it.hasNext()){
      int val = it.next();
      if(value == 30){
          it.remove();
      }
  }
  ```

## 그리고 Vector

* List 인터페이스를 구현한 클래스, 경로명은 `java.util.Vector`
* 객체들을 삽입, 삭제, 검색 할 수 있는 컨테이너 클래스이다.
* 배열의 길이 제한 단점을 극복할 수 있다.
* 삽입되는 객체의 수가 많아지면 자동으로 크기가 조절된다.
* 아이템을 벡터의 맨 마지막, 혹은 중간에 삽입할 수 있다.
* 벡터 맨 뒤에 객체 추가 : 벡터 공간이 모자라면 자동 늘림
* 벡터 중간에 객체 삽입: 뒤에 존재하던 객체는 한칸씩 뒤로 이동
* 임의의 위치에 있는 객체 삭제:  객체 삭제 후 한칸씩 앞으로 자동 이동

![](https://t1.daumcdn.net/cfile/tistory/247A01495588B60010)

* 벡터에는 String,Integer, Person과 같은 다양한 타입의 객체가 삽입 가능

* 벡터는 내부에 삽입된 요소들을 인덱스로 관리, 인덱스는 0부터 시작

* add() 메소드를 이용해서 객체를 삽입, get() 메소드를 이용해서 요소 객체를 얻는다.

* 생성

  ```java
  Vector <Integer> v = new Vector<Integer>();
  ```

* 요소 삽입

  ```java
  v.add("Hello");
  v.add(new Integer(4));
  v.add(new Person());
  v.add(1);// int형 데이터
  v.add('c');// char형 데이터
  v.add(3.14);// double형 데이터
  
  v.add(2, "sahin");// 인덱스 값을 이용하여 삽입
  ```

* 요소 삭제

  ```java
  v.remove(1);
  ```

* 벡터 내의 객체 알아내기

  ```java
  Integer obj = (Integer)v.get(1);
  // 벡터의 1번째 요소를 Integer타입으로 캐스팅
  int i = obj.intValue();// obj에 있는 정수를 알아낸다.
  ```

* 벡터의 용량과 개수 알아내기

  ```java
  int b = v.size();// 벡터에 들어가 있는 요소 개수
  int c = v.capacity();// 요소를 수용할 수 있는 크기.
  ```

##  Q3 InterestingDigit

*InterestingDigits.java - UseArrayList*

```java
public int[] digits(int base) {
		ArrayList<Integer> v = new ArrayList<Integer>();

		// 4자리 미만의 수 이기에, 3번의 for문을 돌린다..
		for (int n = 2; n < base; n++) { // n의 배수가 맞는지 확인하기 위한 n을 정한다.
			boolean ok = true; // arraylist에 n을 추가하기 위해 만든 조건
			for (int k1 = 0; k1 < base; k1++) { // 첫번째 자리의 수
				for (int k2 = 0; k2 < base; k2++) { // 두번째 자리의 수
					for (int k3 = 0; k3 < base; k3++) { // 세번째 자리의 수
						if ((k1 + k2 * base + k3 * base * base) % n == 0 && (k1 + k2 + k3) % n != 0) {
							// n의 배수 숫자로 각 숫자의 합이 n의 배수가 아니면 n을 제외합니다.
							ok = false; // ok는 false로 만든다.
							break; // 반복문을 그만 돌립니다.
						}
					}
					if (!ok)
						break;
				}
				if (!ok)
					break;
			}
			if (ok) // 여기까지 왔는데 ok 가 true?
				v.add(n); // arraylist에 추가해줍니다.
		}

		int[] ans = new int[v.size()]; // arraylist v에 들어있는 객체의 수만큼 크기를 갖는 배열 ans를 만듭니다.
		for (int i = 0; i < v.size(); i++) {
			ans[i] = v.get(i); // 배열로 옮깁니다.
		}

		return ans;
	}
```

* 수학적 생각을 좀 더 첨가해보자
* 모든 자릿수의 합이 n으로 나눠떨어지면, 그 수는 n의 배수이다.
* 즉, 1과 base의 차가 n으로 나눠떨어지면, 어떤 자릿수라도 base로 나눈 나머지가 동일하다.

*InterestingDigits.java - UseVector*

```java
public int[] digitsSimplever(int base) {
			Vector<Integer> v = new Vector<Integer>();
			
			for (int i = 2; i < base; i++) {
				if(((base-1) % i) == 0) v.add(i);
			}
			
			int [] ans = new int [v.size()];
			for(int i = 0; i< v.size(); i++) ans[i] = v.get(i);
			
			return ans;
		}
```

---

## Q4 Palindrome

* 생각한 것
  * 팰린드롬은 홀수만 되는가?
  * 그렇다면 string값을 받고 그것을 charAt로 잘라 ArrayList에 담은 뒤, 맨 마지막을 제외하고 그 안에서 같은 것이 없을때, count를 올려주면 되지않을까? 그 뒤에 원본String의 길이를 더해주면 나올거같은데
  * **응 아니야~** - 이 생각은 String의 맨 끝이 축이 아닌 펠린드롬을 구별해 낼 수 없어 포기

* 해설의 도움
  * 문자열의 길이에 주목하자
  * 팰린드롬은 앞으로 읽으나 뒤로 읽으나 똑같다.
  * 앞에서 시작해서 맨뒤의 문자와 비교했을 떄, 일치하는 부분이 나올 때까지 cnt를 올리고, 일치하는 부분이 나온다해도, 끝까지 비교할 것

*ThePalindrome.java*

```java
package day2_0823;

public class ThePalindrome {
	public int find(String s) {

		for (int i = s.length();; i++) {
			boolean flag = true;
			for (int j = 0; j < s.length(); j++) {
				// 반대쪽에 문자가 존재하는데, 다를 경우 플래그를 변경한다.
				// 길이 - j - 1이 s의 길이보다 적고, j번째 문자와 i-j-1번째 문자와 다르다면 
				if ((i - j - 1) < s.length() && s.charAt(j) != s.charAt(i - j - 1)) {
					flag = false;
					break;
				}
			}
			// 조건을 모두 만족하면 답을 리턴합니다.
			if (flag)
				return i;
		}
	}

	public static void main(String[] args) {
		String s = "abba"; // 4가 나온다.
		ThePalindrome pa = new ThePalindrome();
		System.out.println(pa.find(s));
	}
}

```
