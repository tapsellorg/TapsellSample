#!/bin/bash

PROJECT_DIR=""
if [ -n "${CI_PROJECT_DIR}" ]; then
  PROJECT_DIR="${CI_PROJECT_DIR}"
else
  PROJECT_DIR=$(dirname "$PWD")
fi

FILE="$PROJECT_DIR/build.gradle.kts"

# shellcheck disable=SC2120
update_app_keys() {
  CI_TAPSELL_APP_ID="$1"
  CI_ADMOB_APP_ID="$2"
  CI_APPLOVIN_APP_ID="$3"

  echo "Updating Tapsell App Keys to the new app: TapsellAppId: $CI_TAPSELL_APP_ID - AdmobAppId: $CI_ADMOB_APP_ID - ApplovinAppId: $CI_APPLOVIN_APP_ID"

  if [ -n "$CI_TAPSELL_APP_ID" ] && [ -n "$CI_ADMOB_APP_ID" ] && [ -n "$CI_APPLOVIN_APP_ID" ]; then
      sed -i '' -e "s/const val TAPSELL_APP_ID.*/const val TAPSELL_APP_ID = \"$CI_TAPSELL_APP_ID\"/" "$FILE"
      sed -i '' -e "s/const val ADMOB_APP_ID.*/const val ADMOB_APP_ID = \"$CI_ADMOB_APP_ID\"/" "$FILE"
      sed -i '' -e "s/const val APPLOVIN_APP_ID.*/const val APPLOVIN_APP_ID = \"$CI_APPLOVIN_APP_ID\"/" "$FILE"
      echo "App Keys updated successfully."
  else
      echo "Failed to update app keys: One or more keys are undefined."
  fi
}

update_app_keys "$1" "$2" "$3"