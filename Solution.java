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

		for (int col = 0; col < cb.length; col++)// ����ÿ��
		{
			if (isFesible(cb, row, col))
			{
				cb[row][col] = 'Q';
				traceBack(cb, row + 1);
				cb[row][col] = '.';// ����
			}
		}
	}

	// �ж���λ��[row,col]���ûʺ��Ƿ����
	public boolean isFesible(char[][] cb, int row, int col)
	{
		// ֻ������ϽǵĲ��֣����²��ֻ�δ���ã�������
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
		// ���Խ��� i-j==row-col
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
		{
			if (cb[i][j] == 'Q')
			{
				return false;
			}
		}
		// ���Խ��� i+j=row+col
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