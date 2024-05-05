#!/bin/bash

# shellcheck disable=SC2120
update_app_keys() {
  CI_TAPSELL_APP_ID="$1"
  CI_ADMOB_APP_ID="$2"
  CI_APPLOVIN_APP_ID="$3"

  FILE="$GITHUB_WORKSPACE/build.gradle.kts"

  echo "Project Directory: $FILE"

  if [ -n "$CI_TAPSELL_APP_ID" ] && [ -n "$CI_ADMOB_APP_ID" ] && [ -n "$CI_APPLOVIN_APP_ID" ]; then
      echo "Updating Tapsell App Keys: TapsellAppId: $CI_TAPSELL_APP_ID - AdmobAppId: $CI_ADMOB_APP_ID - ApplovinAppId: $CI_APPLOVIN_APP_ID"
      if [[ "$OSTYPE" == "darwin"* ]]; then
        sed -i '' -e "s/const val TAPSELL_APP_ID.*/const val TAPSELL_APP_ID = \"$CI_TAPSELL_APP_ID\"/" "$FILE"
        sed -i '' -e "s/const val ADMOB_APP_ID.*/const val ADMOB_APP_ID = \"$CI_ADMOB_APP_ID\"/" "$FILE"
        sed -i '' -e "s/const val APPLOVIN_APP_ID.*/const val APPLOVIN_APP_ID = \"$CI_APPLOVIN_APP_ID\"/" "$FILE"
      else
        sed -i -e "s/const val TAPSELL_APP_ID.*/const val TAPSELL_APP_ID = \"$CI_TAPSELL_APP_ID\"/" "$FILE"
        sed -i -e "s/const val ADMOB_APP_ID.*/const val ADMOB_APP_ID = \"$CI_ADMOB_APP_ID\"/" "$FILE"
        sed -i -e "s/const val APPLOVIN_APP_ID.*/const val APPLOVIN_APP_ID = \"$CI_APPLOVIN_APP_ID\"/" "$FILE"
      fi

  else
      echo "Failed to update app keys: One or more keys are undefined."
  fi
}

update_app_keys "$1" "$2" "$3"