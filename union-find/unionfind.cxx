#include <bits/stdc++.h>
using namespace std;

unordered_map<int, int> f;
int islands = 0;

int find(int x) {
    if (!f.count(x)) f[x] = x, islands++;
    if (x != f[x]) f[x] = find(f[x]);
    return f[x];
}

void uni(int x, int y) {
    x = find(x), y = find(y);
    if (x != y) f[x] = y, islands--;
}

int main() {
  uni(1,2);
  assert(find(1) == find(2));
}
