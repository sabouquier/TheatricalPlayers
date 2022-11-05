public class Play {

  public String name;
  public PlayType type;

  public Play(String name, String ptype) {
    this.name = name;
    switch (ptype) {
      case "tragedy":
        this.type = PlayType.TRAGEDY;
        break;
      case "comedy":
        this.type = PlayType.COMEDY;
        break;
      case "history":
        this.type = PlayType.HISTORY;
        break;
      case "pastoral":
        this.type = PlayType.PASTORAL;
        break;
      default:
        throw new Error("unknown type: ${play.type}");
    }
  }
}
