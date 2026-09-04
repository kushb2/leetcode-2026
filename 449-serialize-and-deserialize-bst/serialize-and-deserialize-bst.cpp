/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        if(root == nullptr) return "*,";

        string result = to_string(root->val) + ",";

        result+= serialize(root->left);
        result+= serialize(root->right);
        return result;
        
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        vector<int> nodes = split(data);
        int idx = 0;
        return build(nodes, idx, nodes.size());
        
    }

    TreeNode* build(vector<int> &nodes, int &idx, int n){
        if(idx == n) return nullptr;

        if(nodes[idx] == -1) return nullptr;

        TreeNode* root = new TreeNode(nodes[idx]);
        idx = idx+1;

        root->left = build(nodes,idx,n);
        idx = idx+1;
        root->right = build(nodes,idx,n);

        return root;

    }

    vector<int> split(string data){
        vector<int> nodes;
        int currVal = 0;
        for(auto it: data){
            if(it == ','){
                nodes.push_back(currVal);
                currVal = 0;
            }else if(it == '*'){
                currVal = -1;
            }else{
                currVal = currVal*10 + (it - '0');
            }
        }
        return nodes;
    }

    


};

// Your Codec object will be instantiated and called as such:
// Codec* ser = new Codec();
// Codec* deser = new Codec();
// string tree = ser->serialize(root);
// TreeNode* ans = deser->deserialize(tree);
// return ans;