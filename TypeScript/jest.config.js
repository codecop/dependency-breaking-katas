module.exports = {
  preset: "ts-jest",
  testEnvironment: "node",
  transform: {
    '^.+\\.ts?$': 'ts-jest',
  },
  "collectCoverageFrom": [
    "test/**"
  ],
  "coveragePathIgnorePatterns": [
    "node_modules"
  ],
  "coverageReporters": [
    "json",
    "lcov",
    "text"
  ],
  "coverageThreshold": {
    "global": {
      "branches": 100,
      "functions": 100,
      "lines": 100,
      "statements": 100
    }
  }

};