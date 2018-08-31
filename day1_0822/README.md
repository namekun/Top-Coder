## 180822 TopCoder day1

---

## 시뮬레이션

* 수행해야하는 모든 과정이 나온 문제이다.

---

## 1 . Kiwi Juice Easy

* 생각한 것.

  기존 주스 에서 다음 주스병으로 옮길때.

  경우의 수 두가지 발생

  1. 기존 주스의 양이 옮기는 주스병의 남은 양보다 많을때
     * `옮길 주스병의 용량 - 옮길 주스병에 있는 주스양` 만큼 옮긴다.
  2. 기존 주스의 양이 옮기는 주스병의 남은 양보다 적을때
     * `기존 주스양`을 모두 옮긴다.

```java
	/**
	 * 조건문을 많이 이용한 경우
	 * 
	 * @param capacities
	 *            주스병의 용량을 말하며, 2-50개의 요소가 있는 배열, 각 요소는 1~1000000 사이의 값을 갖는다.
	 * @param bottles
	 *            capacities와 같은 수의 요소가 있는 배열. bottles[i]는 capacities[i]에 들어가 있는 주스를 의미합니다.
	 * @param fromId
	 *            기존 주스병을 말한다. 1~50개의 요소가 있는 배열이다.
	 * @param toId
	 *            옮겨담을 주스병을 말한다. fromId와 같은 수의 요소가 있는 배열입니다.
	 * @return
	 */
	 public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[]
	 toId) {
	
	 for (int i = 0; i < fromId.length; i++) {
	 int from= fromId[i];
	 int to = toId[i];
	 int space = capacities[i] - bottles[i];
	
	 if(space>= f) {
		int tmp = bottles[from];
	 	bottles[to] += tmp;
	 	bottles[from] = 0;
	 } else {
	 	int tmp = space;
	 	bottles[to] += tmp;
	 	bottles[from] -= tmp;
	 	}
	 }
	 return bottles;
	 }
```

* 응용기술1

  * 위와 같이 조건문이 많아지면, 입력에 따라 처리되지않는 부분이 많아지고, 오류검출하기 힘들어진다.
  * Math.min(최소값 찾기)를 이용하면 더욱 간단하게 처리할 수 있다.
  * 옮길 주스는 주스 총량과 기존 주스 병의 용량 중 작은 값이 된다.

  ```java
  	/**
  	 * Math의 최소값 함수 min을 사용하는 경우
  	 * 
  	 * @param capacities
  	 * @param bottles
  	 * @param fromId
  	 * @param toId
  	 * @return
  	 */
  	public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
  
  		for (int i = 0; i < fromId.length; i++) {
  			int from = fromId[i];
  			int to = toId[i];
  
  			int tmp = Math.min(bottles[from], capacities[to] - bottles[to]);
  			
  			bottles[from] -= tmp;
  			bottles[to] += tmp;
  		}
  		return bottles;
  	}
  ```

  * 응용기술2
    * 다음과 같이 생각해보자
      * 옮길 주스 + 기존 주스는 일정하다.
      * 옮길 주스는 주스 총량과 기존 주스 병의 용량 중 작은 값이 된다.

  ```java
  	public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
  		
  		for (int i = 0; i < fromId.length; i++) {
  			
  			int sum = bottles[fromId[i]] + bottles[toId[i]];
  			
  			bottles[toId[i]] = Math.min(sum, capacities[toId[i]]);
  			bottles[fromId[i]] = sum - bottles[toId[i]];
  			
  		}
  		return bottles;
  	}
  ```

---

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

이런형태로 key 값이 중복 되어선 안된다는 점이다. 하지만 value값 ("힘90")은 중복을 허용 합니다. 다시말해 key값을 컬렉션 내의 유일한 key여야 하고, value값은 같은 값이 여러개가 있어도 상관없다.

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

  ex) HashMap<String , Integer> map = new HashMap<String , Integer>();

        Map<String, Integer> map = new HashMap<String, integer>();

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

  ex) map.put("A", 1);

        map.put("B", 2);
    
        map.put("C", 3);
    
        Set set = map.entrySet();
    
        System.out.println("set values are" + set);
    
        (result) set values : [A=1,B=2,C=3]

* **Object get(Object Key)**

  \- 지정된 Key 의 값을 반환한다. 

  ex) map.put("A", 1);

        map.put("B", 2);
    
        map.put("C", 3);
    
        String  val =  (String)map.get("B");

  System.out.println("Value  for key B is: "  +  val); 

  (result)  Value  for key B is 2

* **bloolean isEmpty**

  \- HashMap이 비어있는지 확인한다.

  ex)  boolean  val =  map.isEmpty();

* **Set keySet()**

  \- HashMap에 저장된 모든 키가 저장된 Set을 반환한다.

  ex) map.put("A", 1);

        map.put("B", 2);
    
        map.put("C", 3);
    
        Set keyset = map.keySet();
    
        System.out.println("Key set values are" + keyset);
    
        (result) Key set values are [A,B,C]

* **Object put(Object Key, Object Value)**

  \- HashMap에 키와 값을 저장.

  ex) map.put("A", "aaa");

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
