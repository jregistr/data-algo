module.exports = {
  transform: {
    "^.+\\.tsx?$": "ts-jest",
  },
  // testRegex: "/ts/**/*.ts",
  testMatch: ["**/ts/**/*.ts"],
  testPathIgnorePatterns: ["/lib/", "/node_modules/"],
  moduleFileExtensions: ["ts", "tsx", "js", "jsx", "json", "node"],
  // collectCoverage: true,
};
