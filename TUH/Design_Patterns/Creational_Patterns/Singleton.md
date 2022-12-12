# 싱글톤(Singleton) 패턴

## 인스턴스를 오직 한개만 제공하는 클래스

- 시스템 런타임, 환경 세팅에 대한 정보 등, 인스턴스가 여러개 일 때 문제가 생길 수 있는 경우가 있다. 인스턴스를 오직 한개만 만들어 제공하는 클래스가 필요하다.

## 싱글턴 패턴 구현 방법

### Private 생성자 static 메소드

``` java
public class Settings {
  private static Settings instance;
  
  private Settings() {}
  
  public static Settings getInstance() {
    if (instance == null) {
      instance = new Settings();
    }
    
    return instance;
  }
}
```

1. 생성자를 private으로 만든 이유?
   - 클래스 밖에서 New를 사용해서 인스턴스를 만들지 못하게 하려고
2. getInstance() 메소드를 static으로 선언한 이유?
   - 클래스 밖에서 인스턴스를 만들 수 없게 해뒀기 떄문에 내부에서 인스턴스를 만든뒤 제공해 주려고
3. getInstance()가 멀티쓰레드 환경에서 안전하지 않은 이유?
   - 한 쓰레드에서 instance가 생성되기 전에 다른 스레드가 if문을 평가하고 안으로 들어올 수 있기 때문에

### 동기화(synchronized)를 사용해 멀티쓰레드 환경에 안전하게 만드는 방법

```java
public class Settings {
  private static Settings instance;
  
  private Settings() {}
  
  // 안전하지만 lock을 사용하는 과정에서 성능의 저하가 있을 수 있음
  public static synchronized Settings getInstance() {
    if (instance == null) {
      instance = new Settings();
    }
    
    return instance;
  }
}
```

1. 자바의 동기화 블럭 처리 방법은?
   - Synchronized 키워드를 사용
2. getInstance() 메소드 동기화시 사용하는 락(lock)은 인스턴스의 락인가 클래스의 락인가? 그 이유는?
   - 클래스 락. Java에서 스태틱 메소드 동기화는 클래스당 한 쓰레드에 접근할 수 있게 하기 때문

### 이른 초기화 (eager initialization)을 사용하는 방법

```java
public class Settings {
  private static final Settings INSTANCE = new Settings();

  private Settings() {}

  public static Settings getInstance() {
    return INSTANCE;
  }
}
```

1. 이른 초기화가 단점이 될 수도 있는 이유?
   - 인스턴스를 만들어는 놨는데 쓰진 않는다면 리소스를 낭비하는 것이 될 수 있음
2. 만약에 생성자에서 checked 예외를 던진다면 이 코드를 어떻게 변경해야 할까요?
   - [생성자 예외처리](https://velog.io/@imwy/Java-%EC%83%9D%EC%84%B1%EC%9E%90%EC%97%90%EC%84%9C-checked-%EC%98%88%EC%99%B8%EA%B0%80-%EB%B0%9C%EC%83%9D%ED%95%9C%EB%8B%A4%EB%A9%B4)

### double checked locking으로 효율적인 동기화 블럭 만들기

```java
public class Settings {
  // volatile 키워드를 넣어야 하고 java 1.5 이상부터 작용함
  private static volatile Settings instance;
  
  private Settings() {}
  
  // 인스턴스가 없는 아주 일부의 경우만 대비하여 synchronized 사용
  // 인스턴스 필요한 그 시점에 만들 수 있는 장점이 있음
  public static Settings getInstance() {
    if (instance == null) {
      synchronized (Settings.class) {
        if (instance == null) {
          instance = new Settings();
        }
      }

      return instance;
    }
  }
}

```

1. double check locking이라고 부르는 이유?
   - 체크를 한번 하고난 뒤 싱크로나이즈 블록에서 한번 더 체크 했기 때문
2. instance 변수는 어떻게 정의해야 하는가? 그 이유는?
   - Volatile 를 사용해 정의해야 한다

### Static inner 클래스를 사용하는 방법

```java
private Settings() {}

private static class SettingsHolder {
  private static final Settings SETTINGS = new Settings();
}

public static Settings getInstance() {
  return SettingsHolder.SETTINGS;
}
```

1. 이 방법은 static final를 썼는데도 왜 지연 초기화(Lazy initialization)라고 볼 수 있는가?
   - static inner class는 로드는 되지만 호출하기 전에 초기화하지 않음. 호출 시에 초기화 된다.

```java
// 리플렉션과 직렬화 & 역직렬화에 안전한 코드
// enum은 리플렉션을 막아둠
public enum Settings {
  	INSTANCE;
}
```

1. enum 타입의 인스턴스를 리팩토링을 만들 수 있는가?
2. enum으로 싱글톤 타입을 구현할 때의 단점은?
   - 로딩 시 인스턴스가 만들어지고 상속을 쓸 수 없음
3. 직렬화 & 역직렬화 시에 별도로 구현해야 하는 메소드가 있는가?
   - 없음. enum은 이미 Serializable을 상속하고 있음

## 싱글톤 패턴 구현 깨트리는 방법

### 리플렉션을 사용한다면?

```java
Settings settings = Settings.getInstance();

Constructor<Settings> constructor = Settings.class.getDeclaredConstructor();
constructor.setAccessible(true);
Setting setting1 = constructor.newInstance();

System.out.println(settings == settings1);
```

### 직렬화 & 역직렬화를 사용한다면?

```java
Settings settings = Settings.getInstance();
Settings settings1 = null;

try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
  out.writeObject(settings);
}

try (ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))) {
  setting1 = (Settings) in.readObject();
}

System.out.println(settings == settings1);
```

## 실무에서는 어떻게 쓰이나?

- 스프링에서 빈의 스코프 중에 하나로 싱글톤 스코프
- 자바 java.lang.Runtime
  - 자바 어플리케이션의 실행의 환경, 문맥 정보에 대한 class
- 다른 디자인 패턴(빌더, 퍼사드, 추상 팩토리 등) 구현체의 일부로 쓰이기도 함