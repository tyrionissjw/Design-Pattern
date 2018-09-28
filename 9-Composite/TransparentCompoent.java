public interface TransparentCompoent {
	 public void business();
	 public TransparentComposite getParentComposite();
	 public void setParentComposite(TransparentComposite c);
	 public void addLeaf(TransparentCompoent c);
	 public void removeLeaf(TransparentCompoent c);	 
}