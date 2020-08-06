





# Terminology

Production - An instance that is either a rule or a query



# Clara Methods to look into:
load-rules
add-production-load-order


  (extend-type clojure.lang.Symbol
  com/IRuleSource
  (load-rules [sym]


# Clojure Fns to look into (for Record Def)

## Records
emit-defrecord
(deftest reimporting-deftypes

### Compiler and RT Classes/ etc.
LispReader.readRecord()  

### Record Methods
 (irecord [[i m]]
 (eqhash [[i m]]
 (iobj [[i m]]
 (ilookup [[i m]]
 (imap [[i m]]
 (ijavamap

## Class Related
<!-- Clojure Class Methods -->
class?
supers

## Lib related
*loaded-libs*
(defn- check-cyclic-dependency
loaded-libs

## Variable resolution
*allow-unresolved-vars*
