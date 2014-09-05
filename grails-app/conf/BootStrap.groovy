import grails.util.Environment
import org.gmobile.Manufacturer
import org.gmobile.Phone
import org.gmobile.Variation

class BootStrap {

    def init = { servletContext ->

        if(Environment.TEST != Environment.current) {
            Random random = new Random()
            def phonePrefix = ["Mega", "Giga", "Xtreme", "Galactic", "Nano", "Plutonium", "Crypto", "Edge"]
            def phoneMiddle = ["Galaxy", "Universe", "Element", "Photon", "Compound", "xPhone", "Communicator", "L4", "X4", "AERO", "Spec", "Lens"]
            def letters = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"]
            def numbers = ["1","2","3","4","5"]
            def variations = ["16GB", "32GB", "64GB", "128GB"]
            def manufacturers = ["Samsang", "Sweedia", "Fruit", "Googly", "XTC", "Sonny", "Blueberry"]

            manufacturers.each {
                Manufacturer man = new Manufacturer(name: it)
                random.nextInt(5).times {
                    Phone p = new Phone()
                    p.name = "${phonePrefix[random.nextInt(phonePrefix.size())]} ${phoneMiddle[random.nextInt(phonePrefix.size())]} " +
                            "${letters[random.nextInt(letters.size())]}${numbers[random.nextInt(numbers.size())]}"
                    def price = random.nextInt(500)
                    def first = true
                    variations[0..random.nextInt(4)].each {
                        Variation v = new Variation()
                        v.label = it
                        v.salePrice = price
                        v.listPrice = price
                        v.baseVariation = first
                        first = false
                        price += 100
                        p.addToVariations(v)
                    }
                    man.addToPhones(p)
                }
                man.save(failOnError: true)
            }
        }
    }
    def destroy = {
    }
}
