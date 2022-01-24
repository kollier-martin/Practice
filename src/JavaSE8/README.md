# Custom Functional Interface
______________________________
**String Formatter**
----------------------
This interface allows the creation of custom formats  

Abstract Method: String format(String string1, String string2)  
Example: [String Formatter](StringFormatter.java)

# Functional Packages
______________________________
**Function**
----------------------
Function that accepts a single argument and produces a result  

Abstract Method: R apply(T t)  

**Predicate**
----------------------
Boolean-valued function that takes a single argument  

Abstract Method: boolean test(T t)  

**Consumer**
----------------------
Function that accepts a single argument but returns no result  

Abstract Method: void accept(T t)  

**Supplier**
----------------------
A function that denotes a supplier of results  

Abstract Method: T get()  