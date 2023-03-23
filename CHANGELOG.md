# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Fixed
- Decimal numbers with large scale are converted to String using the E notation, leading to incorrect results with reverse geocoding.

## [1.4.0] - 2021-04-18

### Important

- JCenter is shutting down! Lib was migrated to MavenCentral (#40)

### Added
- Hold unmapped component fields in a `java.util.Map` (#38) thx [@Dexilon](https://github.com/Dexilon)
- Add FIPS mapping (#35)

### Chore

- Move CI to GH Actions (#39)
- Use JUnit 5 (#39)
- Add GH issue templates (#39)
- Upgrade Gradle to 6.8.3 (#39)
- Fix SLF4J Binder in Tests (#36)

## [1.3.0] - 2019-12-11
### Added
- CHANGELOG file to keep track of changes directly in the repo
- Additional fields for components. Like `continent`, `region`, `village`,... (#33, #34)
- Add support for the `proximity` optional search feature (#31)

### Changed
- Upgrade to Gradle 6

### Fixed
- Fix travis CI config

## [1.2.1] - 2019-02-23
### Added
- Additional tests (#26)

### Changed
- Upgrade Gradle

### Fixed
- Bug fix bounds on forward request (#27) 

[Unreleased]: https://github.com/moberwasserlechner/jopencage/compare/1.4.0...HEAD
[1.4.0]: https://github.com/moberwasserlechner/jopencage/compare/1.3.0...1.4.0
[1.3.0]: https://github.com/moberwasserlechner/jopencage/compare/1.2.1...1.3.0
[1.2.1]: https://github.com/moberwasserlechner/jopencage/releases/tag/1.2.1
