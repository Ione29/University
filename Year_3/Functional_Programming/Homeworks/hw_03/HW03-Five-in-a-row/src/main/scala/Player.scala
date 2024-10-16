trait Player {
  def complement: Player
}

case object One extends Player {
  override def complement: Player = Two
}
case object Two extends Player {
  override def complement: Player = One
}
case object Empty extends Player {
  override def complement: Player = Empty
}

