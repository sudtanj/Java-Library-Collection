
public class Tree_Structure {
	private Tree_Structure left;
	private Tree_Structure right;
	private Tree_Structure parent;
	private int data;
	
	public Tree_Structure(int data) {
		this.parent=null;
		this.data=data;
		this.left=null;
		this.right=null;
	}
	
	public Tree_Structure findSuccessor() {
		if(this.getRight()!=null) 
			return this.getRight().findMinimum();
		Tree_Structure Y=this.getParent();
		Tree_Structure temp=this;
		while ((Y!=null) && /*temp == Y.getRight()*/ temp.equals(Y.getRight())) {
			temp=Y;
			Y=Y.getParent();
		}
		return Y;
	}
	
	public Tree_Structure delete() {
		Tree_Structure temp;
		if(this.getLeft()==null || this.getRight()==null) {
			temp=this;
		}
		else {
			temp=this.findSuccessor();
		}
		
		Tree_Structure tempX;
		if(temp.getLeft()!=null) {
			tempX=temp.getLeft();
		} else {
			tempX=temp.getRight();
		}
		
		if(tempX!=null) {
			tempX.setParent(temp.getParent());
		}
		
		if(temp.getParent()==null) {
			this.findRoot().setData(tempX.getData());
		}
		else if(temp.equals(temp.getParent().getLeft())) {
			temp.getParent().left=tempX;
		}
		else {
			temp.getParent().right=tempX;
		}
		
		if(!temp.equals(this)) {
			this.setData(temp.getData());
		}
		
		return temp;
	}
	
	public Tree_Structure findRoot() {
		if(this.getParent()!=null) {
			return this.getParent().findRoot();
		}
		return this;
	}
	
	public Tree_Structure getParent() {
		return parent;
	}


	public void setParent(Tree_Structure parent) {
		this.parent = parent;
	}

	public Tree_Structure findMinimum() {
		if(this.getLeft()!=null)
			return this.getLeft().findMinimum();
		return this;
	}
	
	public Tree_Structure findMaximum() {
		if(this.getRight()!=null) 
			return this.getRight().findMaximum();
		return this;

	}
	
	public Tree_Structure getLeft() {
		return left;
	}
	public void setLeft(Tree_Structure left) {
		this.left = left;
		this.left.parent=this;
	}
	public Tree_Structure getRight() {
		return right;
	}
	public void setRight(Tree_Structure right) {
		this.right = right;
		this.right.parent=this;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tree_Structure other = (Tree_Structure) obj;
		if (data != other.data)
			return false;
		return true;
	}

	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
	
	
	
}
