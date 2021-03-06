---
title: Changelog - Alfred Telemetry
date: 11 July 2019
report: true
colorlinks: true
---
<!--
Changelog for Alfred Telemetry

See http://keepachangelog.com/en as reference
Version template:

## [X.X.X] - yyyy-MM-dd
### Added (for new features)
### Changed (for changes in existing functionality)
### Deprecated (for soon-to-be removed features)
### Removed (for now removed features)
### Fixed (for any bug fixes)
### Security (in case of vulnerabilities)
### YANKED (for reverted functionality in)
 -->
 
# Alfred Telemetry Changelog

## [0.3.0] - UNRELEASED

### Added

* Added metrics tracker for NodeDAO and AclDAO (to get MaxTxNode )[[#42]]

[#42]: https://github.com/xenit-eu/alfred-telemetry/pull/42
## [0.2.0] - 2020-10-29

### Added 

* Beans of type `MeterRegistryCustomizer` allow customization of a `MeterRegistry` before registration [[#10]]
* Added metrics for Solr tracking and Solr sharding [[#22]]
* Included Grafana dashboard in the test setup [[#13]]

### Fixed

* Alfresco 6.1 fails to start if the out-of-the-box metrics are disabled [[#15]]

[#10]: https://github.com/xenit-eu/alfred-telemetry/issues/10
[#13]: https://github.com/xenit-eu/alfred-telemetry/issues/13
[#15]: https://github.com/xenit-eu/alfred-telemetry/issues/15
[#22]: https://github.com/xenit-eu/alfred-telemetry/issues/22

## [0.1.1] - 2019-08-13

### Fixed

* MeterFilters are applied after metrics are possibly already exposed to the global MeterRegistry [[#6]]

### Changed
* Changed default logging level to INFO [[#4]]
* Disable Cache metrics by default [[#7]][[#9]]

[#4]: https://github.com/xenit-eu/alfred-telemetry/pull/4
[#6]: https://github.com/xenit-eu/alfred-telemetry/issues/6
[#7]: https://github.com/xenit-eu/alfred-telemetry/issues/7
[#9]: https://github.com/xenit-eu/alfred-telemetry/issues/9

## [0.1.0] - 2019-07-11

Initial, early access release including:

- Support for the `Graphite`, `JMX` and `Prometheus` Micrometer `MeterRegistry`, which are automatically registered 
if available on the classpath.
- Provided out of the box metrics: jvm, files, database, process and ticket metrics. 
- Registering of custom metrics via the `meterRegistry`, Micrometers static API or custom `MeterBinder` implementations.
- The possibility to customize meters with custom `MeterFilter` implementations.
- Integration with the out of the box Alfresco metrics included since 6.1.
- Limited support for Care4Alf compatible metrics.
- ...