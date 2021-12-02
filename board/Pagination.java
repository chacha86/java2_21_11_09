package board;

public class Pagination {

	// 변수 -> 정보의 저장. 처리X
	int currentPageNo = 1;
	int pageCountPerBlock = 5;
	int itemCountPerPage = 3;
	int totalItemCount = 0;

	public Pagination(int totalItemCount) {
		this.totalItemCount = totalItemCount;
	}

	// 메서드 -> 정보의 처리
	public int getCurrentBlockNo() {
		return (int)Math.ceil(currentPageNo / (double)pageCountPerBlock);
	}
	
	public int getStartPageNoInBlock() {
		return pageCountPerBlock * (getCurrentBlockNo() - 1) + 1;
	}
	
	public int getEndPageNoInBlock() {
		
		int endPageNo = getStartPageNoInBlock() + pageCountPerBlock - 1;
		
		if(endPageNo > getLastPageNo()) {
			endPageNo = getLastPageNo();
		}
		
		return endPageNo;
	}
	
	public int getStartIdx() {
		return itemCountPerPage * (currentPageNo - 1);
	}
	
	public int getEndIdx() {
		
		int endIdx = getStartIdx() + itemCountPerPage;
		if(endIdx > totalItemCount) {
			endIdx = totalItemCount;
		}
		
		return endIdx;
	}
	
	public int getLastPageNo() {
		// 게시물 30개 -> 페이지당 3개씩 보여준다 -> 30 / 3 = 10;
		// 게시물 31개 -> 페이지당 3개씩 보여준다 -> 31 / 3 = 10.xxx;
		// 총페이지 개수(마지막 페이지 번호) => 올림(전체 게시물 수 / 페이지당 게시물 수)		
		return (int)Math.ceil((double)totalItemCount / itemCountPerPage);
		
	}
}
