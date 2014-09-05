package org.gmobile

class Variation {

    Boolean baseVariation
    String label
    BigDecimal listPrice
    BigDecimal salePrice

    static belongsTo = [phone: Phone]

    static constraints = {
        label nullable: true
    }
}
