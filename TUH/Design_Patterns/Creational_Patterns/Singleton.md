# 생성 패턴(Creational Patterns)

## 싱글톤(Singleton) 패턴

### 인스턴스를 오직 한개만 제공하는 클래스

- 시스템 런타임, 환경 세팅에 대한 정보 등, 인스턴스가 여러개 일 때 문제가 생길 수 있는 경우가 있다. 인스턴스를 오직 한개만 만들어 제공하는 클래스가 필요하다.

### 싱글턴 패턴 구현 방법

1. Private 생성자 static 메소드

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

2. 동기화(synchronized)를 사용해 멀티쓰레드 환경에 안전하게 만드는 방법

```java
public static synchronized class Settings {
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

3. 이른 초기화 (eager initialization)을 사용하는 방법

```java
private static final Settings INSTANCE = new Settings();

private Settings() {}

public static Settings getInstance() {
  return INSTANCE;
}
```

4. double checked locking으로 효율적인 동기화 블럭 만들기

```java
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
```

5. Static inner 클래스를 사용하는 방법

```java
private Settings() {}

private static class SettingsHolder {
  private static final Settings SETTINGS = new Settings();
}

public static Settings getInstance() {
  return SettingsHolder.SETTINGS;
}
```

### 싱글톤 패턴 구현 깨트리는 방법

1. 리플렉션을 사용한다면?

```java
Settings settings = Settings.getInstance();

Constructor<Settings> constructor = Settings.class.getDeclaredConstructor();
constructor.setAccessible(true);
Setting setting1 = constructor.newInstance();

System.out.println(settings == settings1);
```

2. 직렬화 & 역직렬화를 사용한다면?

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

