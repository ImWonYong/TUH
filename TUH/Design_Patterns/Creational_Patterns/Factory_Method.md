# 팩토리 메소드(Fatory method) 패턴

## 구체적으로 어떤 인스턴스를 만들지는 서브 클래스가 정한다.

- 다양한 구현체(Product)가 있고, 그중에서 특정한 구현체를 만들 수 있는 다양한 팩토리(Creator)를 제공할 수 있다.

- 어떻게 하면 확장에는 열려있고 변경에는 닫혀있게 할 수 있을까?

## 팩토리 메소드 패턴 구현 방법

### ShipFactory

```java
// java 11 부터 인터페이스에 private 메서드 가능
// java 11 미만이라면 인터페이스와 구현체 사이에 추상 클래스를 넣어 Default 값을 넣도록 할 수 있다.
public interface ShipFactory {
  
  default Ship orderShip(String name, String email) {
    validate(name, email);
    prepareFore(name);
    Ship ship = createShip();
    sendEmailTo(email, ship);
    
    return ship;
  }
  
  Ship createShip();
  
  private void validate(String name, String email) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("배 이름을 지어주세요.");
    }
    if (email == null || email.isBlank()) {
      throw new IllegalArgumentException("연락처를 남겨주세요.");
    }
  }
  
  private void prepareFor(String name) {
    System.out.println(name + " 만들 준비 중");
  }
  
  private void sendEmailTo(String email, Ship ship) {
    System.out.println(ship.getName() + " 다 만들었습니다.");
  }
}
```

```java
public class Ship {
  private String name;
  private String color;
  private String logo;
  
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getColor() { return color; }
  public void setColor(String color) { this.color = color; }
  public String getLogo() { return logo; }
  public void setLogo(String logo) { this.logo = logo; }
}
```

### WhiteShipFactory

```java
public class WhiteShipFactory implements ShipFactory {
  @Override
  public Ship createShip() {
    return new WhiteShip();
  }
}
```

```java
public class WhiteShip exetnds Ship {
  public WhiteShip() {
    setName("whiteship");
    setColor("white");
    setLogo("⛵︎");
  }
}
```

### BlackShipFactory

```java
public class BlackShipFactory implements ShipFactory {
  @Override
  public Ship createShip() {
    return new BlackShip();
  }
}
```

```java
public class BlackShip extends Ship {
  public BlackShip() {
    setName("blackship");
    setColor("black");
    setLogo("⚓︎")
  }
}
```



클라이언트 코드는 여전히 새로운 팩토리가 생기거나 새로운 제품이 생기면 변경해야 한다. 하지만 집중해야 하는 것은 구현체와 팩토리를 확장할 때 기존 구현체와 팩토리를 변경하지 않는다는 것이다.

```java
public class Client {
  public static void main(String[] args) {
    Client client = new Client();
    client.print(new WhiteShipFactory(), "whiteship", "wonyong@gmail.com");
    client.print(new BlackShipFactory(), "blackship", "wonyong@gmail.com");
  }
  
  private void print(ShipFactory shipFactory, String name, String email) {
    System.out.println(shipFactory.orderShip(name, email));
  }
}
```

이런 식으로 클라이언트의 코드 변경도 최소화할 수 있는 방법이 있다.

## 팩토리 메소드 패턴 복습

- 팩토리 메소드 패턴을 적용했을 때의 장점은? 단점은?
  - 장점 : 기존 코드를 건드리지 않고 새로운 인스턴스를 다른 방법으로 확장하게 해준다. 이게 되는 이유는 느슨한 결합을 사용했기 때문
  - 단점 : 각자의 역할을 나누는 과정에서 클래스가 많아짐
- "확장에 열려있고 변경에 닫혀있는 객체 지향 원칙"을 설명하세요.
  - OCP 원칙. 기존 코드를 변경하지 않으면서 새로운 기능을 추가할 수 있는 구조로 만드는 것.
- 자바 8에 추가된 default 메소드에 대해 설명하세요.
  - 인터페이스에 기본적인 구현체를 만들 수 있도록 해준 것. 추상 클래스를 그렇게 많이 사용할 필요 없어짐. 인터페이스에서 그 역할을 할 수 있게 되었기 때문. 자바 9에서는 인터페이스에 private 메서드를 사용할 수 있도록 추가됨.

## 팩토리 메소드 패턴

실무에서 어떻게 사용하나?

- 단순한 팩토리 패턴
  - 매개변수의 값에 따라 또는 메소드에 따라 각기 다른 인스턴스를 리턴하는 단순한 버전의 팩토리 패턴
  - java.lang.Calendar 또는 java.lang.NumberFormat
- 스프링 BeanFactory
  - Object 타입의 Product를 만드는 BeanFactory라는 Creator
