import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution
{
	ArrayList<List<String>> res = new ArrayList<>();

	public List<List<String>> solveNQueens(int n)
	{
		char[][] cb = new char[n][n];
		for (int i = 0; i < cb.length; i++)
		{
			Arrays.fill(cb[i], '.');
		}
		traceBack(cb, 0);
		return res;
	}

	public void traceBack(char[][] cb, int row)
	{
		if (row == cb.length )
		{
			ArrayList<String> list = new ArrayList<>();
			for (int i = 0; i < cb.length; i++)
			{
				list.add(String.valueOf(cb[i]));
			}
			res.add(list);
			return;
		}

		for (int col = 0; col < cb.length; col++)// 遍历每列
		{
			if (isFesible(cb, row, col))
			{
				cb[row][col] = 'Q';
				traceBack(cb, row + 1);
				cb[row][col] = '.';// 回退
			}
		}
	}

	// 判断在位置[row,col]放置皇后是否可行
	public boolean isFesible(char[][] cb, int row, int col)
	{
		// 只检查左上角的部分，以下部分还未放置，不需检查
		for (int i = 0; i < row; i++)
		{
			if (cb[i][col] == 'Q') // check row
			{
				return false;
			}
		}
		for (int i = 0; i < col; i++)
		{
			if (cb[row][i] == 'Q') // check row
			{
				return false;
			}
		}
		// 正对角线 i-j==row-col
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
		{
			if (cb[i][j] == 'Q')
			{
				return false;
			}
		}
		// 副对角线 i+j=row+col
		for (int i = row - 1, j = col + 1; i >= 0 && j < cb.length; i--, j++)
		{
			if (cb[i][j] == 'Q')
			{
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args)
	{
		double time =System.currentTimeMillis();
		System.out.println(new Solution().solveNQueens(100));
		System.out.println(System.currentTimeMillis()-time);
	}
}