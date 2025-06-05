package org.example.validation

fun SaveRequest.toEntity(): SomeEntity {
    return SomeEntity(
        sf1 = this.sf1,
        sf2 = this.sf2,
        sf3 = this.sf3,
        inf = this.inf,
        df = this.df,
        bf = this.bf
    )
}
