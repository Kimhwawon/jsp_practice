package kr.co.ict;

// 원래 VO(value dbject)와 DTO(data transfer object)는 큰 차이는 두지 않고 사용합니다. 
// 굳이 차이를 두자면 VO는 DB테이블 형태를 그대로 전달할 때
// DTO는  DB에서 꺼넨 데이터가 가공되어 전달할 때 쓰는것을 지칭할때 씁니다.
// 다만 DTO와 VO는 엄격하게 구분되지 않고 프로그래머에 따라서는
// 그냥 DTO를  VO와 완전히 동일하게 쓰는 경우도 있으므로 
// 사용하는 사람이 부르고 싶은대로 부르셔도 무방합니다. 
public class BoardDTO {
	private int boardCount; // 전체 글 개수
	private int currentPage; // 현재 보고있는 페이지
	private int totalPages; //전체 페이지 개수
	private int startPage; // 시작 페이지 번호
	private int endPage; // 끝 페이지 번호
	private static final int NAV_NUM = 5; // 페이지는 10개씩 링크 표시(하단에 깔릴 버튼은 10개씩)
	private static final int BOARD_NUM = 20; // 글도10개씩 표시 (DAO의 limit 구문도 함께 수정해야함)
	
	// 생성자 생성시 모든 정보를 자동으로 구하도록 처리
	public BoardDTO(int boardCount, int currentPage) {
		// 총 글 갯수와, 현재 조회중인 페이지 정보를 입력받아 아래에 깔릴 버튼개수, 현재 깔려야하는 번호대를 구합니다. 
		this.boardCount = boardCount;
		this.currentPage = currentPage;
		
		//  글이 없다면
		if(boardCount == 0) {
			// 아래에 깔리는 버튼 자체가 없어야함
			this.totalPages = 0;
			this.startPage = 0;
			this.endPage = 0;
		// 글이 있다면
		}else {
			// <<게시글 개수를 이용해 전체 페이지 갯수 구하기(totalPages값 구하기)>>
			//  * 게시글 관련이므로 상수 BOARD_ NUM을 사용합니다. 
			if(boardCount % BOARD_NUM == 0) {
				// 전체 글 개수 % 10이 0으로 떨어짐 => 10의 배수 갯수로 페이지 갯수는 10을 나눈 결과값
				totalPages = boardCount / BOARD_NUM;
			}else {
				// 전체 글 개수 % 10이 0으로 떨어지지 않음 => 10개씩 표현하다 마지막에 남은 글들을 표현할 페이지가 하나 더 필요함
				totalPages = (boardCount / BOARD_NUM) + 1;
			
			} // 페이지 갯수 구하기 종료
			
			// <<현재 조회중인 페이지 그룹의  시작 페이지 구하기(startPage값 구하기)>>
			//  * 시작, 끝 페이지는 게시글이 아닌 아래 깔릴 페이지 버튼이므로 NAV_NUM을 사용합니다. 
			int navNum = 0; // 식별번호
			if(currentPage % NAV_NUM == 0 ) {
					// 10배수 페이지는 자신이 속한 그룹보다 페이지 식별숫자가 1크게 나옴
				navNum = (currentPage-1) / NAV_NUM; // (50번 페이지의 경우 41~50그룹에 속하므로 실제로는 4가 나와야 하므로)
			}else{
				navNum = currentPage / NAV_NUM; // (51번페이지 -1 / 10 해도 5가 나옴,  50 - 1 / 10하면 4가 나옴.)
			}
			// navNum = (currentPage - 1) / NAV_NUM;
			
			// 식별번호 navNum이 구해졌으면 * 10 + 1을 해서 시작번호를 구합니다. 
			startPage = (navNum * NAV_NUM) + 1;
			
			// << 현재 조회중인 페이지 그룹의 끝페이지 구하기(endPage값 구하기)>>
			endPage = startPage + (NAV_NUM -1);
			if(endPage > totalPages) {
				endPage = totalPages;
			}
			// endPage = Math.min(startPage + (10 -1), totalPages);
			// endPage = (startPage + (10 - 1) > totalPages) ? totalPages : startPage + (10 -1);
			
		}
	} // end constructor 생성자 닫는 부분
	
	public int getBoardCount() {
		return boardCount; //총 글 개수
	}
	//밑에 버튼을 깔지 말고는 결정하기 위한 bool자료형
	public boolean hasNoBoard() {
		return boardCount ==0; // 표시할 게시물이 없으면 버튼도 깔 필요 없음
	}
	public boolean hasBoard() {
		return boardCount > 0; // 표시할 게시물이 있다면 버튼을 깔아줘야함
	}
	// 페이지의 총 개수를 알려준는 getter
	public int getTotalPages() {
		return totalPages;
	}
	// 해당 페이지 그룹의 시작페이지
	public int getStrartPage() {
		return startPage; 
	}
	// 해당 페이지 그룹의 끝페이지
	public int  getEndPage() {
		return endPage;
	}
	// 디버깅을 위한 toString
	@Override
	public String toString() {
		return "BoardDTO [boardCount=" + boardCount + ", currentPage=" + currentPage + ", totalPages=" + totalPages
				+ ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
}
