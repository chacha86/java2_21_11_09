package board;

public class Pagination {

	// 변수 -> 정보의 저장. 처리X
	int currentPageNo = 1;
	int pageCountPerBlock = 5;
	int itemCountPerPage = 3;

	// 메서드 -> 정보의 처리
	public int getCurrentBlockNo() {
		return (int)Math.ceil(currentPageNo / (double)pageCountPerBlock);
	}
	
	public int getStartPageNoInBlock() {
		return pageCountPerBlock * (getCurrentBlockNo() - 1) + 1;
	}
	
	public int getEndPageNoInBlock() {
		return getStartPageNoInBlock() + pageCountPerBlock - 1;
	}
	
	public int getStartIdx() {
		return itemCountPerPage * (currentPageNo - 1);
	}
	
	public int getEndIdx() {
		return getStartIdx() + itemCountPerPage;
	}
	
}
