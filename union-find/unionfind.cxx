#include <bits/stdc++.h>
using namespace std;

template<typename T>
class UF {
	unordered_map<T, T> f;
	int islands = 0;
public:	
	T find(T x) {
	    if (!f.count(x)) f[x] = x, islands++;
	    if (x != f[x]) f[x] = find(f[x]);
	    return f[x];
	}
	
	void uni(T x, T y) {
	    x = find(x), y = find(y);
	    if (x != y) f[x] = y, islands--;
	}
};

int main() {
  string a = "a", b = "b";
  UF<string> uf;
  uf.uni(a,b);
  assert(uf.find(a) == uf.find(b));
}
