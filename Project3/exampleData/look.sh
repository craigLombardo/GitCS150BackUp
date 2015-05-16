#!/bin/bash
if [[ $# -ne 3 ]]
then
	printf "Need 3 args, found $#" >&2
	printf "\n"
	exit 1
fi

ONE=$1
TWO=$2
THREE=`echo $3`
if [[ ! -f $THREE ]]
then
	echo "$THREE doesn't exits">&2
	exit 2
fi
grep -w "$ONE - $TWO\|$TWO - $ONE" $THREE
