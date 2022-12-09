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
   - 

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
   - 

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

