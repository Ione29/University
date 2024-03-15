

final class course_01$_ {
def args = course_01_sc.args$
def scriptPath = """course_01.sc"""
/*<script>*/
def fact(n : Int): Int = {
    if (n == 0) 1
    else n* fact(n - 1)
}


/*</script>*/ /*<generated>*//*</generated>*/
}

object course_01_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new course_01$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export course_01_sc.script as `course_01`

