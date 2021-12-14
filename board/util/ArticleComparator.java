package board.util;

import board.BoardArticle;

import java.util.Comparator;

public class ArticleComparator implements Comparator<BoardArticle> {
    int type;// 1. 오름차순, 2. 내림차순
    int target; // 1. 번호, 2. 조회수

    public ArticleComparator(int type, int target) {
        this.type = type;
        this.target = target;
    }

    @Override
    public int compare(BoardArticle o1, BoardArticle o2) {

        int result = getCompareResult(o1, o2);

        if(type == 2) {
            result *= -1;
        }

        return result;

    }

    private int getCompareResult(BoardArticle o1, BoardArticle o2) {

        if(target == 1) { // 번호
            return getCompareResultById(o1, o2);
        } else { // 조회수
            return getCompareResultByHit(o1, o2);
        }
    }
    private int getCompareResultById(BoardArticle o1, BoardArticle o2) {
        if(o1.id > o2.id) {
            return 1;
        }

        return -1;
    }
    private int getCompareResultByHit(BoardArticle o1, BoardArticle o2) {
        if(o1.hit > o2.hit) {
            return 1;
        }

        return -1;
    }
}