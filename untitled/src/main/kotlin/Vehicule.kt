open class Vehicule(private var brand : String, var price : Int) {
    var tag = "This car of brand $brand, price: $price"
    init{
        println(tag)
    }
    constructor(speed : Double):this(speed:"Citroën")
}