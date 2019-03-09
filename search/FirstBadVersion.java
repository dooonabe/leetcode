package com.dooonabe.search;

/**
 * 278. First Bad Version
 * Created on 2019/3/9.
 */
public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}

interface Control {
    boolean isBadVersion(int version);
}

class VersionControl implements Control {

    @Override
    public boolean isBadVersion(int version) {
        return false;
    }
}