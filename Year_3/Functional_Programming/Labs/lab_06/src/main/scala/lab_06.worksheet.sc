type Gradebook = List[(String, Int)]
val gradebook = List(("G", 3), ("F", 10), ("M", 6), ("P", 4))
def increment(g: Gradebook): Gradebook =
    g.map{
        case (student, grade) if grade >= 5 => (student, grade + 1)
        case other => other
    }

increment(gradebook)

def average(g : Gradebook): Double = {
    val (sum, count) = g.foldRight((0, 0)) {
        case ((_, grade), (acc, count)) => (acc + grade, count + 1)
    }

    if(count == 0) 0
    else sum.toDouble / count
}

average(gradebook)

def percentage(g: Gradebook): (Double, Double) = {
    
    //Method 1
    /* val (passed, failed) = g.foldRight((0, 0)) {
        case ((_, grade), (acc1, acc2)) => if(grade >= 5) (acc1 + 1, acc2) else (acc1, acc2 + 1)
    } 

    if(passed + failed == 0) (0, 0)
    else (passed * 100 / g.size, failed * 100 / g.size)*/
    
    //Method 2
    val passedCount = g.filter((name, grade) => if(grade >= 5) true else false)
    val passedPerc = passedCount.size * 100 / g.size 
    val failedPerc = 100 - passedPerc

    (passedPerc, failedPerc)
}

percentage(gradebook)

def pass(g: Gradebook): List[String] = {
    val filteredNames = g.filter((name, grade) => if(grade >5) true else false)

    filteredNames.map{
        case(name, grade) => name
    }
}

pass(gradebook)

def honorsList(g: Gradebook): List[String] = {

    val filteredNames = g.filter((name, grade) => if(grade> 5) true else false)
    
    filteredNames.sortBy(-_._2).map(_._1)
}
    
honorsList(gradebook)

type Name = String
type Lecture = String
type ExtGradebook = List[(Name,Lecture,Int)]
val egradebook = List(("John","FP",4), ("John", "CA", 3), ("Joan", "FP", 10))

def atLeastOneFail(g: ExtGradebook): List[Name] = {

    val filteredFails = g.filter((name, _, grade) => if (grade < 5) true else false)
    
    val filteredNames = filteredFails.map{
        case(name, course, grade) => name
    }
    
    filteredNames.distinct
}

atLeastOneFail(egradebook)

