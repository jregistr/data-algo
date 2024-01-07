// https://leetcode.com/problems/valid-anagram/description/
struct ValidAnagram;

fn ascii_index(byte: &u8) -> usize {
    *byte as usize - 97
}

impl ValidAnagram {
    pub fn is_anagram(s: String, t: String) -> bool {
        if s.len() != t.len() {
            return false;
        }

        let mut chars = [0usize; 26];
        for byte in s.bytes() {
            let index = ascii_index(&byte);
            chars[index] += 1;
        }

        for byte in t.bytes() {
            let index = ascii_index(&byte);
            chars[index] -= 1;
        }

        chars.iter().all(|total| *total == 0)
    }


}