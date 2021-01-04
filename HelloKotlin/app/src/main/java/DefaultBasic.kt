val a = "패키지 스코프"
// public - 어떤 패키지에서도 접근 가능
// internal - 같은 모듈 내에서만 접근 가능
// private - 같은 파일 내에서만 접근 가능
// protected - 사용하지않음

class B {
    val a = "클래스 스코프"
    // public - 클래스 외부에서 늘 접근 가능
    // private - 클래스 내부에서만 접근 가능
    // protected - 클래스 자신과 상속받은 클래스에서 접근 가능능
    fun print() {
        println(a)
    }
}

fun main() {
    val a = "함수 스코프"

    println(a)
    B().print()
}