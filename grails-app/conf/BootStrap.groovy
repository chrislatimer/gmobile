import org.gmobile.Manufacturer
import org.gmobile.Phone

class BootStrap {

    def init = { servletContext ->

        def m = new Manufacturer(name:"Apple")
        def p = new Phone(name:"iPhone")
        m.addToPhones(p)
        m.save()
    }
    def destroy = {
    }
}
