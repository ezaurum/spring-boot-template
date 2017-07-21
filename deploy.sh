#!/usr/bin/env bash
gradle bootrepackage
aws s3 cp build/libs/admin-1.0.0.RELEASE.jar s3://example-bucket

