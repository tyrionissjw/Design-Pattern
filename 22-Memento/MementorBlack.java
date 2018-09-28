import java.util.ArrayList;
import java.util.List;

public class MementorBlack
  implements MementorWide, MementorNarrow
{
  private List<String> states = new ArrayList();
  private int index;

  public MementorBlack(List<String> paramList, int paramInt)
  {
    this.states = paramList;
    this.index = paramInt;
  }

  public List<String> getStates() {
    return this.states;
  }

  public int getIndex() {
    return this.index;
  }

  public void setStates(List<String> paramList) {
    this.states = paramList;
  }

  public void setIndex(int paramInt) {
    this.index = paramInt;
  }
}