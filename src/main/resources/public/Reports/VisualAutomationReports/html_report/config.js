report({
  "testSuite": "Visual Automation Testing",
  "tests": [
    {
      "pair": {
        "reference": "..\\bitmaps_reference\\backstop_default_BackstopJS_Homepage_0_document_0_desktop.png",
        "test": "..\\bitmaps_test\\20211109-132147\\backstop_default_BackstopJS_Homepage_0_document_0_desktop.png",
        "selector": "document",
        "fileName": "backstop_default_BackstopJS_Homepage_0_document_0_desktop.png",
        "label": "BackstopJS Homepage",
        "requireSameDimensions": true,
        "misMatchThreshold": 0.1,
        "url": "http://115.112.185.58:3200/rcm/enrm/risk-assessment",
        "referenceUrl": "",
        "expect": 0,
        "viewportLabel": "desktop",
        "diff": {
          "isSameDimensions": true,
          "dimensionDifference": {
            "width": 0,
            "height": 0
          },
          "misMatchPercentage": "0.29",
          "analysisTime": 61
        },
        "diffImage": "..\\bitmaps_test\\20211109-132147\\failed_diff_backstop_default_BackstopJS_Homepage_0_document_0_desktop.png"
      },
      "status": "fail"
    },
    {
      "pair": {
        "reference": "..\\bitmaps_reference\\backstop_default_BackstopJS_Homepage_0_document_1_phone.png",
        "test": "..\\bitmaps_test\\20211109-132147\\backstop_default_BackstopJS_Homepage_0_document_1_phone.png",
        "selector": "document",
        "fileName": "backstop_default_BackstopJS_Homepage_0_document_1_phone.png",
        "label": "BackstopJS Homepage",
        "requireSameDimensions": true,
        "misMatchThreshold": 0.1,
        "url": "http://115.112.185.58:3200/rcm/enrm/risk-assessment",
        "referenceUrl": "",
        "expect": 0,
        "viewportLabel": "phone",
        "diff": {
          "isSameDimensions": true,
          "dimensionDifference": {
            "width": 0,
            "height": 0
          },
          "misMatchPercentage": "0.00"
        }
      },
      "status": "pass"
    },
    {
      "pair": {
        "reference": "..\\bitmaps_reference\\backstop_default_BackstopJS_Homepage_0_document_2_tablet.png",
        "test": "..\\bitmaps_test\\20211109-132147\\backstop_default_BackstopJS_Homepage_0_document_2_tablet.png",
        "selector": "document",
        "fileName": "backstop_default_BackstopJS_Homepage_0_document_2_tablet.png",
        "label": "BackstopJS Homepage",
        "requireSameDimensions": true,
        "misMatchThreshold": 0.1,
        "url": "http://115.112.185.58:3200/rcm/enrm/risk-assessment",
        "referenceUrl": "",
        "expect": 0,
        "viewportLabel": "tablet",
        "diff": {
          "isSameDimensions": true,
          "dimensionDifference": {
            "width": 0,
            "height": 0
          },
          "misMatchPercentage": "0.00"
        }
      },
      "status": "pass"
    }
  ],
  "id": "EnGRC"
});