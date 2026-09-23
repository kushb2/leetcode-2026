class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        unordered_map<int,unordered_set<int>> row, col, block;


        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){

                int num = board[i][j];
                if(num == '.') continue;
                if(row[i].contains(num)) return false;
                row[i].insert(num);

                if(col[j].contains(num)) return false;
                col[j].insert(num);

                int blockNo = (i / 3)*3 + (j/3);
                if(block[blockNo].contains(num)) return false;
                block[blockNo].insert(num);
            }
        }
      
        return true;

        
    }
};