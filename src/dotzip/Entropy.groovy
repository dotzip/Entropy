package dotzip

def code = [:]
def total = 0
def entropy = 0
def redundancy = 0
int i = 0

new File("Data.txt").eachLine { line ->
    line.split(){ eachChar ->
        code.put(eachChar, 0)
    }
    line.split(){ eachChar ->
        code."$eachChar"++
        total++
    }
}

for(i; i < 256; i++){
    if(code."${(char)i}" != null) {
        entropy += (-(float)code."${(char)i}" / total) * log(((float)code."${(char)i}") / total, 2)
    }
}

redundancy = log(Math.pow(total, 2), 2) - entropy

def log(def x, def base) {
    return (Math.log(x) / Math.log(base));
}

//println code
println "entropy: $entropy"
println "redundancy: $redundancy"